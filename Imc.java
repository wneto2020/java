import java.io.*;
import java.nio.charset.StandardCharsets;

class Imc {

    public static float calc(float weight, float height){
        return (weight/(height * height));
    }

    public void treatmentCsv() throws IOException {
        int count = 0;
        String row, nome;
        float imc;

        BufferedReader csvReader = new BufferedReader(new FileReader("dataset.CSV"));
        BufferedWriter csvWrite = new BufferedWriter(new FileWriter("meuNomeCompleto.txt"));

                while ((row = csvReader.readLine()) != null) {
                        String[] data = row.split(";");

                    if (data.length == 4) {
                            if (count > 0) {
                                nome = data[0] + " " + data[1];
                                imc = calc(Float.parseFloat(data[2].replace(',', '.')),
                                        Float.parseFloat(data[3].replace(',', '.')));
                                System.out.println(nome.toUpperCase() + " " + String.format("%.2f", imc));
                                csvWrite.write(nome.toUpperCase() + " " + String.format("%.2f", imc) + "\n");
                            }
                        } else {
                            System.out.println("Conjunto faltando informações");
                        }

                    count += 1;

                }
            csvWrite.close();
            csvReader.close();
            }
        }



class execute {

    public static void main(String[] args) throws IOException {
        Imc Test = new Imc();
        Test.treatmentCsv();


    }
}

