package ru.mirea.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gui_interface {


    static class task extends JFrame
    {
        private  final  String[][]  menuFile =
                {{"Файл"     ,  "Ф",  "", ""},
                        {"Открыть"  ,  "О", "O", ""},
                        {"Сохранить",  "С", "S", ""},
                        {"Сохранить как", "С", "ctrl+S", ""}};

        private JMenu createMenuItems(final String[][] items)
        {
            // Создание выпадающего меню
            JMenu menu = new JMenu(items[0][0]);
            menu.setMnemonic(items[0][1].charAt(0));
            for (int i = 1; i < items.length; i++) {
                // пункт меню "Открыть"
                JMenuItem item = new JMenuItem(items[i][0]);
                item.setMnemonic(items[i][1].charAt(0)); // русская буква
                // установим клавишу быстрого доступа (латинская буква)
                item.setAccelerator(KeyStroke.getKeyStroke(items[i][2].charAt(0)));
                if (item.getText()=="Открыть")
                    fileChooserCreation(item);
                if (items[i][3].length() > 0)
                    item.setIcon(new ImageIcon(items[i][3]));
                menu.add(item);
            }
            return menu;
        }
        void fileChooserCreation(JMenuItem menuItem){
            JFileChooser fileChooser = new JFileChooser();
            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fileChooser.setDialogTitle("Выбор файла");
                    int result = fileChooser.showOpenDialog(task.this);
                    // Если директория выбрана, покажем ее в сообщении
//                    if (result == JFileChooser.APPROVE_OPTION )
//                        JOptionPane.showMessageDialog(task.this, fileChooser.getSelectedFile());
                }
            });
        }
//        private JMenu createSubmenus()
//        {
//            JMenu text = new JMenu("Текст");
//            // и несколько вложенных меню
//            JMenu style = new JMenu("Стиль");
//            JMenuItem bold = new JMenuItem("Жирный");
//            JMenuItem italic = new JMenuItem("Курсив");
//            JMenu font = new JMenu("Шрифт");
//            JMenuItem arial = new JMenuItem("Arial");
//            JMenuItem times = new JMenuItem("Times");
//            font.add(arial); font.add(times);
//            // размещаем все в нужном порядке
//            style.add(bold);
//            style.add(italic);
//            style.addSeparator();
//            style.add(font);
//            text.add(style);
//            return text;
//        }
        task() {
            super("Basic_GUI");
            setLayout(null);

            // Cоздание многострочных полей
            JTextArea area1 = new JTextArea(35, 100);
            // Шрифт и табуляция
            area1.setFont(new Font("Dialog", Font.PLAIN, 14));
            area1.setLineWrap(true);
            area1.setWrapStyleWord(true);

            // создаем строку главного меню
            JMenuBar menuBar = new JMenuBar();
            // Создание меню "Файл"
            menuBar.add(createMenuItems(menuFile));
            // Создание меню "Редактирование"
//            menuBar.add(createMenuItems(menuEdit));
//            menuBar.add(createSubmenus());
            // JMenuBar использует блочное расположение (заполнитель вполне уместен)
            menuBar.add(Box.createHorizontalGlue());

            // поместим меню в наше окно
            setJMenuBar(menuBar);
            // Добавим поля в окно
            JPanel contents = new JPanel();
            contents.add(new JScrollPane(area1));
            setContentPane(contents);
            setSize(1150,750);
            setVisible(true);
        }
    }

}

