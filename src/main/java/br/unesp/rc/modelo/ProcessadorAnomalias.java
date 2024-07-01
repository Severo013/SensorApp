package br.unesp.rc.modelo;

import java.util.List;

public class ProcessadorAnomalias implements IProcessadorDados {

    //preciso corrigir
    //Classe para processamento de anomalias nos valores de sensor
    @Override
    public void processarDados(List<Sensor> sensores, ETipo tipo) {
        System.out.println("\n============================================\n");
        if (tipo == ETipo.QUALIDADE_AGUA) {
            System.out.println("Analisando anomalias nos sensores de água.");
        } else if (tipo == ETipo.QUALIDADE_AR) {
            System.out.println("Analisando anomalias nos sensores de ar.");
        }
        System.out.println("\n============================================\n");
        for (ISensor sensor : sensores) {
            int flag = 0;
            StringBuilder retorno = new StringBuilder();
            
            if (sensor.obterTipo() == tipo) {
                //0-pH, 1-Turbidez, 2-Condutividade
                //0-CO2, 1-PM2.5, 2-O3
                double min = (tipo == ETipo.QUALIDADE_AGUA ? EParametroAnomalia.PH.getMin() : EParametroAnomalia.CO2.getMin()),
                        max = (tipo == ETipo.QUALIDADE_AGUA ? EParametroAnomalia.PH.getMax() : EParametroAnomalia.CO2.getMax());
                if (sensor.obterValores().get(0) < min || sensor.obterValores().get(0) > max) {
                    flag = 1;
                    retorno.append("\nAnomalia detectada no sensor de id: " + sensor.obterId() + "\n\t");
                    retorno.append(tipo == ETipo.QUALIDADE_AGUA ? "pH " : "Concetração de CO2 (ppm) ");
                    retorno.append((sensor.obterValores().get(0) > max) ? "acima" : "abaixo");
                    retorno.append(" do valor ideal, entre " + min + " e " + max + ". Valor: ");
                    retorno.append(String.format("%.2f", sensor.obterValores().get(0)));
                    if (ETipo.QUALIDADE_AR == tipo) {
                        retorno.append(" ppm.");
                    }
                }

                min = (tipo == ETipo.QUALIDADE_AGUA ? EParametroAnomalia.TURBIDEZ.getMin() : EParametroAnomalia.PM2_5.getMin());
                max = (tipo == ETipo.QUALIDADE_AR ? EParametroAnomalia.PM2_5.getMax() : 0);

                if (sensor.obterValores().get(1) > min) {
                    if (flag == 0) {
                        retorno.append("\nAnomalia detectada no sensor de id: " + sensor.obterId());
                    }
                    retorno.append("\n\t");
                    flag = 1;
                    retorno.append(tipo == ETipo.QUALIDADE_AGUA ? "Turbidez" : "Concentração de PM2.5");
                    retorno.append(" acima do valor ideal (");
                    retorno.append(tipo == ETipo.QUALIDADE_AGUA ? "até 1 NTU" : "até 12 µg/m³");

                    retorno.append("). Valor: " + String.format("%.2f", sensor.obterValores().get(1)));
                    retorno.append(tipo == ETipo.QUALIDADE_AGUA ? " NTU." : " µg/m³ ");
                    if (tipo == ETipo.QUALIDADE_AR) {
                        retorno.append(" - poluição " + (sensor.obterValores().get(1) < max ? "moderada." : "severa."));
                    }

                }

                min = (tipo == ETipo.QUALIDADE_AGUA ? EParametroAnomalia.CONDUTIVIDADE.getMin() : 0);
                max = (tipo == ETipo.QUALIDADE_AGUA ? EParametroAnomalia.CONDUTIVIDADE.getMax() : EParametroAnomalia.O3.getMax());

                if ((tipo == ETipo.QUALIDADE_AGUA ? sensor.obterValores().get(2) < min : false)
                        || sensor.obterValores().get(2) > max) {
                    if (flag == 0) {
                        retorno.append("\nAnomalia detectada no sensor de id: " + sensor.obterId());
                    }
                    retorno.append("\n\t");
                    flag = 1;
                    retorno.append(tipo == ETipo.QUALIDADE_AGUA ? "Condutividade " : "Concentração de O3 ");
                    if (tipo == ETipo.QUALIDADE_AGUA && sensor.obterValores().get(2) < min) {
                        retorno.append("abaixo");
                    } else {
                        retorno.append("acima");
                    }
                    retorno.append(" do valor ideal (");
                    if (tipo == ETipo.QUALIDADE_AGUA) {
                        retorno.append("entre " + min + " e " + max + " µS/cm³");
                    } else if (tipo == ETipo.QUALIDADE_AR) {
                        retorno.append("até " + max + " ppb");
                    }
                    retorno.append("). Valor: " + String.format("%.2f", sensor.obterValores().get(2)));
                    retorno.append(tipo == ETipo.QUALIDADE_AGUA ? " µS/cm." : " ppb.");
                }
                System.out.println(flag==0 ? "\nNenhuma anomalia detectada no sensor de id: " + sensor.obterId() : retorno);
            }
        }
    }
}
