/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Admin2 extends javax.swing.JFrame {


    ArrayList<MenuItem> prod=new ArrayList<>();
    ArrayList<MenuItem> lista=new ArrayList<>();
    ArrayList<CompositeProduct> meniu=new ArrayList<>();



    public Admin2() throws IOException {
        initComponents();
        Deserializare(lista);
        Deserializare2(meniu);
        if(lista.isEmpty())
        produse(lista);

        tabel_produse(lista);
        tabel_comanda(prod);
       //Deserializare2(meniu);
        tabel_comenzi();
    }

    public void Serializare2(List<CompositeProduct> alimente)
    {
        try{
            FileOutputStream fileOut =new FileOutputStream("C:\\Users\\HP\\Desktop\\TP teme\\Tema4_tp\\Serializare2.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            for(CompositeProduct b:alimente)
            {
                out.writeObject(b);
            }
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Serializare(ArrayList<MenuItem> alimente)
    {
        try{
            FileOutputStream fileOut =new FileOutputStream("C:\\Users\\HP\\Desktop\\TP teme\\Tema4_tp\\Serializare.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            for(MenuItem b:alimente)
            {
                out.writeObject(b);
            }

            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Deserializare(ArrayList<MenuItem> alimente)
    {
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\HP\\Desktop\\TP teme\\Tema4_tp\\Serializare.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            MenuItem e;
            while((e=(MenuItem) in.readObject())!=null)
            { alimente.add(e);
            }
            in.close();
            fileIn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i<20;i++)
            System.out.println();
    }

    public void Deserializare2(ArrayList<CompositeProduct> alimente)
    {
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\HP\\Desktop\\TP teme\\Tema4_tp\\Serializare2.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            CompositeProduct e;
            while((e=(CompositeProduct) in.readObject())!=null)
            { alimente.add(e);
            }
            in.close();
            fileIn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i<20;i++)
            System.out.println();
    }


    public void produse(List<MenuItem> alimente) throws IOException {

    MenuItem a;

        List<String> list=new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\HP\\Desktop\\TP teme\\Tema4_tp\\products.csv"))) {
            list=  stream
                    .filter(line->!line.startsWith("Title"))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        int i=0;
        for(String aux:list)
        {
            List<String>s= List.of(aux.split(","));
            a=new BaseProduct();
            a.setTitle(s.get(0));
            a.setRating(Double.parseDouble(s.get(1)));
            a.setCalories(Integer.parseInt(s.get(2)));
            a.setProtein(Integer.parseInt(s.get(3)));
            a.setFat(Integer.parseInt(s.get(4)));
            a.setSodium(Integer.parseInt(s.get(5)));
            a.setPrice(Integer.parseInt(s.get(6)));
            int count=0;
            for(MenuItem aa: alimente)
            {
                if(aa.getTitle().equals(a.getTitle()))
                    count=1;
            }
            if(count==0)
            {alimente.add(a);
                i++;}
        }
    }


    public void tabel_comanda(List<MenuItem>lista)
    {
        DefaultTableModel df= (DefaultTableModel)Meniu.getModel();
        df.setRowCount(0);
        Object rowData[] = new Object[7];
        for(int i=0;i<lista.size();i++)
        {
            rowData[0]=lista.get(i).getTitle();
            rowData[1]=lista.get(i).getRating();
            rowData[2]=lista.get(i).getCalories();
            rowData[3]=lista.get(i).getProtein();
            rowData[4]=lista.get(i).getFat();
            rowData[5]=lista.get(i).getSodium();
            rowData[6]=lista.get(i).getPrice();

            df.addRow(rowData);
        }
    }
    public void tabel_produse(List<MenuItem>l)
    {
        DefaultTableModel df= (DefaultTableModel)Produse.getModel();
        df.setRowCount(0);
        Object rowData[] = new Object[7];
        for(int i=0;i<l.size();i++)
        {
            rowData[0]=l.get(i).getTitle();
            rowData[1]=l.get(i).getRating();
            rowData[2]=l.get(i).getCalories();
            rowData[3]=l.get(i).getProtein();
            rowData[4]=l.get(i).getFat();
            rowData[5]=l.get(i).getSodium();
            rowData[6]=l.get(i).getPrice();

            df.addRow(rowData);
        }
    }

    public void tabel_comenzi()
    {

        DefaultTableModel df= (DefaultTableModel)Meniuri.getModel();
        CompositeProduct c=new CompositeProduct();

        df.setRowCount(0);
        Object rowData[] = new Object[7];
        for(int i=0;i<meniu.size();i++)
        {
            rowData[0]=meniu.get(i).getTitle();
            rowData[1]=meniu.get(i).Rating();
            rowData[2]=meniu.get(i).Calories();
            rowData[3]=meniu.get(i).Protein();
            rowData[4]=meniu.get(i).Fat();
            rowData[5]=meniu.get(i).Sodium();
            rowData[6]=meniu.get(i).computePrice();

            df.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Meniuri = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Produse = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Meniu = new javax.swing.JTable();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        Create = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Nume = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        Meniuri.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Title Menu", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"
                }
        ));
        Meniuri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MeniuriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Meniuri);

        Produse.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Title ", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"
                }
        ));
        Produse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProduseMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Produse);

        Meniu.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Base Products"
                }
        ));
        Meniu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MeniuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Meniu);

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        Create.setText("Create");
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 0));
        jLabel1.setText("Base Product");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 0));
        jLabel2.setText("Menus");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 0));
        jLabel3.setText("Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(Create, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                                        .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Nume, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(289, 289, 289))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(282, 282, 282))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Nume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addGap(15, 15, 15)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(63, 63, 63)
                                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                                        .addComponent(Create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 366, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    String na;
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:



    }

MenuItem b=new BaseProduct();
    private void ProduseMouseClicked(java.awt.event.MouseEvent evt) {

        DefaultTableModel d1= (DefaultTableModel)Produse.getModel();
        int SelectIndex=Produse.getSelectedRow();
        b.setTitle(d1.getValueAt(SelectIndex,0).toString());
        b.setRating(Double.parseDouble(d1.getValueAt(SelectIndex,1).toString()));
        b.setCalories(Integer.parseInt(d1.getValueAt(SelectIndex,2).toString()));
        b.setProtein(Integer.parseInt(d1.getValueAt(SelectIndex,3).toString()));
        b.setFat(Integer.parseInt(d1.getValueAt(SelectIndex,4).toString()));
        b.setSodium(Integer.parseInt(d1.getValueAt(SelectIndex,5).toString()));
        b.setPrice(Integer.parseInt(d1.getValueAt(SelectIndex,6).toString()));



    }

    private void addActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        prod.add(b);
        b=new BaseProduct();
tabel_comanda(prod);

    }

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
       CompositeProduct c=new CompositeProduct();

        int cond =1;
        for(CompositeProduct prod:meniu)
        {
            if(Nume.getText().equals(prod.getTitle()))
                cond=0;
        }
        if(cond==1)
        {
            for(MenuItem aux:prod)
            {c.Items.add(aux);
            }
            CompositeProduct dD=new CompositeProduct(Nume.getText(),c.Rating(),c.Calories(),c.Protein(),c.Fat(),c.Sodium(),c.computePrice(),c.Items);
           dD.setTitle(Nume.getText());
            meniu.add(dD);
           Serializare2(meniu);
            c=new CompositeProduct();
            tabel_comenzi();
            JOptionPane.showMessageDialog(this,"Meniu adaugat");
            prod.clear();
            tabel_comanda(prod);

        }
    else
        {
            JOptionPane.showMessageDialog(this,"Exista un meniu cu acest nume");
        }
    }

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Serializare2(meniu);
        this.setVisible(false);
        Admin_view v=new Admin_view();
        v.setVisible(true);

    }

    private void MeniuMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void MeniuriMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        DefaultTableModel d1= (DefaultTableModel)Produse.getModel();
        int SelectIndex=Produse.getSelectedRow();
        na=(d1.getValueAt(SelectIndex,0).toString());

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Admin2().setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton Create;
    private javax.swing.JButton Exit;
    private javax.swing.JTable Meniu;
    private javax.swing.JTable Meniuri;
    private javax.swing.JTextField Nume;
    private javax.swing.JTable Produse;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration
}
