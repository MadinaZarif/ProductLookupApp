package com.javarush;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.awt.*;

public class ProductLookup {
    private static Map<Integer, String> productMap = new HashMap<>();
    private static Map<Integer, String> imageMap = new HashMap<>();
    private static JTextField inputField;
    private static JLabel productLabel;
    private static JLabel imageLabel;
    public static void main(String[] args) {
        // Создание карты продуктов с их номерами
        productMap.put(332, "Ananas");
        productMap.put(114, "Apfel Gruen");
        productMap.put(110, "Apfel Rot");
        productMap.put(269, "Аpricose");
        productMap.put(117, "Аvocado");
        productMap.put(155, "Banane Bio");
        productMap.put(205, "Banane Chiquita PY");
        productMap.put(100, "Banane Gelb");
        productMap.put(120, "Birne");
        productMap.put(378, "Erdbeere");
        productMap.put(183, "Grapefruit");
        productMap.put(181, "Ingwer Bio");
        productMap.put(188, "Johannesbeere rot");
        productMap.put(256, "Kiwi");
        productMap.put(142, "Kiwi Gold");
        productMap.put(169, "Mango");
        productMap.put(349, "Melone Wasser KA");
        productMap.put(152, "Nektarine");
        productMap.put(145, "Stachelbeere Rot");
        productMap.put(222, "Tomate Rispe");
        productMap.put(323, "Weisskohl");
        productMap.put(308, "Zucchini");
        productMap.put(320, "Zwiebel lauch");
        productMap.put(3333, "BlumenErde");
        productMap.put(190, "Zitrone");
        productMap.put(312, "Blumenkohl");
        productMap.put(101, "Gurken S");
        productMap.put(138, "Karrote");
        productMap.put(149, "Karrote Eur");
        productMap.put(201, "Kohlrabi");
        productMap.put(177, "Paprika Rot");
        productMap.put(301, "Radieschen");
        productMap.put(258, "Salat Kopf");

        //Brot
        productMap.put(5009, "Apfeldreieck");
        productMap.put(4409, "Baguette zwiebel");
        productMap.put(1716, "Berliner");
        productMap.put(4691, "Berliner eierlikoer");
        productMap.put(4214, "BierStange");
        productMap.put(540, "Brezel Schweibisch");
        productMap.put(4216, "BroetSeelSalz");
        productMap.put(4213, "BroetKartof");
        productMap.put(4217, "BroetKuerbiskern");


        // Добавление путей к изображениям продуктов
        imageMap.put(332, "images/ananas.jpg");
        imageMap.put(114, "images/apfelgruen.jpg");
        imageMap.put(110, "images/apfelrot.jpg");
        imageMap.put(269, "images/aprekose.jpg");
        imageMap.put(117, "images/avocado.jpg");
        imageMap.put(155, "images/bananebio.jpg");
        imageMap.put(205, "images/bananebio.jpg");
        imageMap.put(100, "images/bananebio.jpg");
        imageMap.put(120, "images/birne.jpg");
        imageMap.put(256, "images/kiwi.jpg");
        imageMap.put(142, "images/kiwi.jpg");
        imageMap.put(169, "images/mango.jpg");
        imageMap.put(349, "images/melone.jpg");
        imageMap.put(152, "images/nektarine.jpg");
        imageMap.put(183, "images/grapefruit.jpg");

        imageMap.put(378, "images/erdbeere.jpg");
        imageMap.put(181, "images/ingwerbio.jpg");
        imageMap.put(188, "images/johannisbeere.jpg");
        imageMap.put(145, "images/stachelbeere.jpg");
        imageMap.put(222, "images/tomaterispe.jpg");
        imageMap.put(323, "images/weisskohl.jpg");
        imageMap.put(308, "images/zucchini.jpg");
        imageMap.put(320, "images/zwiebellauch.jpg");
        imageMap.put(3333, "images/blumenerde.jpg");
        imageMap.put(190, "images/zitrone.jpg");
        imageMap.put(312, "images/blumenkohl.jpg");
        imageMap.put(101, "images/gurken.jpg");
        imageMap.put(138, "images/karotte.jpg");
        imageMap.put(149, "images/karotte.jpg");
        imageMap.put(201, "images/kohlrabi.jpg");
        imageMap.put(177, "images/paprikabio.jpg");
        imageMap.put(156, "images/paprikarot.jpg");
        imageMap.put(301, "images/radieshen.jpg");
        imageMap.put(258, "images/salatkopf.jpg");


        // Создание окна
        JFrame frame = new JFrame("Product Lookup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Создание панели
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Поле ввода
        inputField = new JTextField();
        panel.add(inputField, BorderLayout.NORTH);

        // Метка для вывода названия продукта
        productLabel = new JLabel("Введите номер продукта", SwingConstants.CENTER);
        panel.add(productLabel, BorderLayout.CENTER);

        // Метка для вывода изображения продукта
        imageLabel = new JLabel("", SwingConstants.CENTER);
        panel.add(imageLabel, BorderLayout.SOUTH);

        // Добавление панели в окно
        frame.add(panel);

        // Добавление слушателя на ввод
        inputField.addActionListener(e -> lookupProduct());

        // Отображение окна
        frame.setVisible(true);
    }

    private static void lookupProduct() {
        try {
            int productNumber = Integer.parseInt(inputField.getText());

            // Поиск продукта по номеру
            String productName = productMap.get(productNumber);
            String imagePath = imageMap.get(productNumber);

            // Вывод результата
            if (productName != null && imagePath != null) {
                productLabel.setText("Продукт: " + productName);
                ImageIcon imageIcon = new ImageIcon(imagePath);
                Image image = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(image);
                imageLabel.setIcon(imageIcon);
            } else {
                productLabel.setText("Продукт с номером " + productNumber + " не найден.");
                imageLabel.setIcon(null);
            }
        } catch (NumberFormatException e) {
            productLabel.setText("Пожалуйста, введите допустимый номер продукта.");
            imageLabel.setIcon(null);
        }
    }
}