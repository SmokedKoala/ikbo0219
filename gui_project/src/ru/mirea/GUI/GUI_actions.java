package ru.mirea.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static ru.mirea.GUI.GUI_interface.*;
import java.io.*;
import java.util.Scanner;

public class GUI_actions {
    private static String path;

    static void fileChooserCreation(JMenuItem menuItem, task task, JTextArea area) {
        JFileChooser fileChooser = new JFileChooser();
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Выбор файла");
                int result = fileChooser.showOpenDialog(task);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getAbsolutePath();
                    try {
                        FileReader in = new FileReader(path);
                        Scanner scan = new Scanner(in);
                        while (scan.hasNextLine()) {
                            area.append(scan.nextLine() + "\n");
                        }
                        in.close();
                        task.setTitle(fileChooser.getSelectedFile().getName());
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
    }

    static void createNewTxt(JMenuItem menuItem, task task) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(fileChooser.getCurrentDirectory(), "file.txt"));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Выбор директории");
                int result = fileChooser.showOpenDialog(task);
                if (result == JFileChooser.APPROVE_OPTION) {
                    path = fileChooser.getSelectedFile().toString();
                    File file = new File(path);
                    try {
                        file.createNewFile();
                        task.setTitle(file.getName());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

    }

    static void saveChanges(JMenuItem menuItem, JTextArea area) {
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedWriter outFile = null;
                try {
                    outFile = new BufferedWriter(new FileWriter(path));
                    area.write(outFile);   // *** here: ***
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    if (outFile != null) {
                        try {
                            try {
                                outFile.close();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    static void saveAs (JMenuItem menuItem, JTextArea area, task task){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(fileChooser.getCurrentDirectory(), "savedFile.txt"));
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fileChooser.setDialogTitle("Выбор директории");
                int result = fileChooser.showOpenDialog(task);
                if (result == JFileChooser.APPROVE_OPTION) {
                    path = fileChooser.getSelectedFile().toString();
                    File file = new File(path);
                    try {
                        file.createNewFile();
                        BufferedWriter outFile = null;
                        try {
                            outFile = new BufferedWriter(new FileWriter(path));
                            area.write(outFile);   // *** here: ***
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        } finally {
                            if (outFile != null) {
                                try {
                                    try {
                                        outFile.close();
                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                } catch (Exception exception) {
                                    exception.printStackTrace();
                                }
                            }
                        }
                        task.setTitle(file.getName());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });

    }
}
