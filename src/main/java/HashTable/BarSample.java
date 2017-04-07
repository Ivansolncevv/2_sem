package HashTable;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class BarSample {

    public static void main(String[] args) throws IOException {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        String category = "количество";
        data.addValue(21, category, "и");
        data.addValue(9, category, "он");
        data.addValue(8, category, "-");
        JFreeChart chart = ChartFactory.createBarChart("Население городов", "Город", "Население, чел", data);
        BufferedImage image = chart.createBufferedImage(600, 400);
//        File file = new File("C:\\temp\\chart.png");
//        ImageIO.write(image, "png", file);
//        Desktop.getDesktop().open(file);
    }
}

