package org.algo;

import org.algo.loaddata.bean.Bean01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LoadCsvFile {

    public static void main(String[] args) {
        List<Bean01> list = loadDataByCsv(10000);
        System.out.println(list.get(list.size() - 1).toString());
    }

    /**
     * 从csv中加载测试数据
     * @param size 加载的数量
     * @return 返回加载的数据
     */
    public static List<Bean01> loadDataByCsv(int size) {
        String csvFile = "C:\\Users\\TWL\\Desktop\\large-csv\\Purchase_Orders_and_Contracts.csv";
        String line;
        String csvSplitBy = ",";

        List<Bean01> list = new ArrayList<>(size);

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int k = 0;
            while ((line = br.readLine()) != null) {
                if (0 == k++) {
                    continue;
                }
                String[] data = line.split(csvSplitBy);
                // 处理每一行的数据
                // 例如，打印每一行的第一个字段
                Bean01 temp = new Bean01();
                temp.setType(data[0]);
                temp.setNumber(Integer.valueOf(data[1]));
                temp.setDocument(data[3]);
                temp.setDescription(Integer.valueOf(data[4]));
                temp.setDate(LocalDate.parse(data[5], DateTimeFormatter.ofPattern("MM/dd/yyyy")));
                temp.setAmount(Double.valueOf(data[6]));
                list.add(temp);

                if (k > size) {
                    break;
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
    }
}
