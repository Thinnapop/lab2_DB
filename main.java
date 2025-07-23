import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) {
        String inputFilePath = "2024 QS World University Rankings 1.1 (For qs.com).csv";
        String outputFilePath = "QS-World-University-Rankings-2024_updated.csv";

        ArrayList<Unidata> universityList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (fields.length < 2) continue;
                String rank2024 = fields[0].trim();
                String rank2023 = fields[1].trim();
                if (rank2023.contains("-") || rank2024.contains("-")) continue; 

                Unidata uni = Unidata.fromCSV(line);
                universityList.add(uni);
            }
            Collections.sort(universityList);

            bw.write("2024 RANK,2023 RANK,Institution Name,Country Code,Country,SIZE,FOCUS,RES.,AGE,STATUS," +
                     "Academic Reputation Score,Academic Reputation Rank,Employer Reputation Score,Employer Reputation Rank," +
                     "Faculty Student Score,Faculty Student Rank,Citations per Faculty Score,Citations per Faculty Rank," +
                     "International Faculty Score,International Faculty Rank,International Students Score,International Students Rank," +
                     "International Research Network Score,International Research Network Rank,Employment Outcomes Score," +
                     "Employment Outcomes Rank,Sustainability Score,Sustainability Rank,Overall SCORE");
            bw.newLine();

            for (Unidata uni : universityList) {
                String rounded = uni.roundAllFields().toLowerCase();
                if (!rounded.isEmpty()) {
                    bw.write(rounded);
                    bw.newLine();
                }
            }

            System.out.println("Writing successfully completed.");

        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }
}  