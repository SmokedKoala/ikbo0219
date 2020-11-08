package ru.mirea.GUI;

import jdk.jfr.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_interface {


    static class task extends JFrame
    {
        JTextArea area1;
        private  final  String[][]  menuFile =
                {{"Файл"     ,  "Ф",  "", ""},
                        {"Новый", "Н", "N", ""},
                        {"Открыть"  ,  "О", "O", ""},
                        {"Сохранить",  "С", "S", ""},
                        {"Сохранить как", "shift S", "shift S", ""}};

        private JMenu createMenuItems(final String[][] items)
        {
            // Создание выпадающего меню
            JMenu menu = new JMenu(items[0][0]);
            menu.setMnemonic(items[0][1].charAt(0));
            for (int i = 1; i < items.length; i++) {
                // пункт меню "Открыть"
                JMenuItem item = new JMenuItem(items[i][0]);
//                KeyStroke ctrlNKeyStroke = KeyStroke.getKeyStroke("control N");
                item.setMnemonic(items[i][1].charAt(0)); // русская буква
                // установим клавишу быстрого доступа (латинская буква)
                item.setAccelerator(KeyStroke.getKeyStroke("control "+items[i][2]));
                if (item.getText()=="Открыть")
                    GUI_actions.fileChooserCreation(item, task.this, area1);
                if (item.getText()=="Новый")
                    GUI_actions.createNewTxt(item, task.this);
                if (item.getText()=="Сохранить")
                    GUI_actions.saveChanges(item, area1);
                if (item.getText()=="Сохранить как")
                    GUI_actions.saveAs(item, area1, task.this);
                if (items[i][3].length() > 0)
                    item.setIcon(new ImageIcon(items[i][3]));
                menu.add(item);
            }
            return menu;
        }

        task() {
            super("Basic_GUI");
            setLayout(null);

            // Cоздание многострочных полей
            area1 = new JTextArea(35, 100);
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

