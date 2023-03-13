/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DeliveryService_view extends javax.swing.JFrame {


    ArrayList<MenuItem> cos=new ArrayList<>();

    Employee employee=new Employee();
    int id;
DeliveryService delivery1=new DeliveryService();
    public DeliveryService_view(int idd,DeliveryService dd) throws  IOException
    {
        initComponents();
        jLabel4.setText(String.valueOf(idd));

delivery1=dd;
        id=idd;
        tabel(delivery1.meniu);
        }

    public DeliveryService_view() throws IOException {
        initComponents();
        ArrayList<MenuItem> ali=new ArrayList<>();
        produse(ali);
        //d.meniu=ali;
        tabel(ali);

    }

    public void Deserializare(Map<Order,ArrayList<MenuItem>> h)
    {
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\HP\\Desktop\\TP teme\\Tema4_tp\\Delivery1.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            BaseProduct e;
            h=(Map<Order,ArrayList<MenuItem>>) in.readObject();
            in.close();
            fileIn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Serializare(Map<Order,ArrayList<MenuItem>> h)
    {
        try{
            FileOutputStream fileOut =new FileOutputStream("C:\\Users\\HP\\Desktop\\TP teme\\Tema4_tp\\Delivery1.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(h);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void Deserializare(ArrayList<MenuItem> ali)
    {
        ArrayList<MenuItem> alimente=new ArrayList<>();
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

    }
    public void Deserializare2(ArrayList<MenuItem> ali)
    {
        List<CompositeProduct> alimente=new ArrayList<>();
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

        for(CompositeProduct c:alimente)
        {ali.add(c);}
    }

    public void produse(ArrayList<MenuItem> alimente1) throws IOException {

        BaseProduct a;


List<BaseProduct> bb=new ArrayList<>();
        List<String> list=new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\HP\\Desktop\\TP teme\\Tema4_tp\\Serializare.csv"))) {
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
            for(BaseProduct aa: bb)
            {
                if(aa.getTitle().equals(a.getTitle()))
                    count=1;
            }
            if(count==0)
            {bb.add(a);
                i++;}

        }

        for(BaseProduct aux:bb)
            alimente1.add(aux);


    }
    public void tabel_comanda()
    {
        DefaultTableModel df= (DefaultTableModel)jTable2.getModel();
        df.setRowCount(0);
        Object rowData[] = new Object[7];
        for(int i=0;i<cos.size();i++)
        {
            rowData[0]=cos.get(i).getTitle();
            rowData[1]=cos.get(i).getRating();
            rowData[2]=cos.get(i).getCalories();
            rowData[3]=cos.get(i).getProtein();
            rowData[4]=cos.get(i).getFat();
            rowData[5]=cos.get(i).getSodium();
            rowData[6]=cos.get(i).getPrice();
            df.addRow(rowData);
        }
    }

    public void tabel( List<MenuItem> l)
    {
        DefaultTableModel df= (DefaultTableModel)jTable1.getModel();
        df.setRowCount(0);
        Object rowData[] = new Object[7];
        for(int i=0;i<l.size();i++)
        {
          MenuItem b= new BaseProduct();
            CompositeProduct c=new CompositeProduct();
        if(l.get(i) instanceof BaseProduct) {
            b = (BaseProduct) l.get(i);
            rowData[0] = b.getTitle();
            rowData[1] = b.getRating();
            rowData[2] = b.getCalories();
            rowData[3] = b.getProtein();
            rowData[4] = b.getFat();
            rowData[5] = b.getSodium();
            rowData[6] = b.getPrice();
        }
        else
        {
            c= (CompositeProduct) l.get(i);
            rowData[0] = c.getTitle();
            rowData[1] = c.getRating();
            rowData[2] = c.getCalories();
            rowData[3] = c.getProtein();
            rowData[4] = c.getFat();
            rowData[5] = c.getSodium();
            rowData[6] = c.getPrice();
        }
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
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        Add = new javax.swing.JButton();
        titletxt = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ratingtxt = new javax.swing.JTextField();
        caloriestxt = new javax.swing.JTextField();
        proteintxt = new javax.swing.JTextField();
        fattxt = new javax.swing.JTextField();
        sodiumtxt = new javax.swing.JTextField();
        pricetxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        calo = new javax.swing.JLabel();
        trre = new javax.swing.JLabel();
        fa = new javax.swing.JLabel();
        sod = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        Buy = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 51, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Title ", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"
                }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Menu Item"
                }
        ));
        jScrollPane2.setViewportView(jTable2);

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Title");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Rating");

        calo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        calo.setText("Calories");

        trre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        trre.setText("Protein");

        fa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fa.setText("Fat");

        sod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sod.setText("Sodium");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Price");

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        Buy.setText("Buy");
        Buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Client ID:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel5.setText("Data");

        jLabel6.setText("Ora");

        jTextField1.setText("jTextField1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(Add, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                                                                .addGap(25, 25, 25)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(Buy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(2, 2, 2))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(titletxt, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(31, 31, 31)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(ratingtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(29, 29, 29)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(caloriestxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(calo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(proteintxt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(trre, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(36, 36, 36)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(fattxt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(fa, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(sodiumtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(sod, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(311, 311, 311)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(pricetxt)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))))
                                .addGap(171, 171, 171))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(330, 330, 330)
                                .addComponent(jLabel3)
                                .addGap(4, 4, 4)
                                .addComponent(jLabel4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                .addGap(22, 22, 22)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(calo)
                                                        .addComponent(trre)
                                                        .addComponent(fa)
                                                        .addComponent(sod))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(titletxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ratingtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(caloriestxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(proteintxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(fattxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sodiumtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(28, 28, 28)
                                                .addComponent(Buy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pricetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>
    BaseProduct b=new BaseProduct();
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        DefaultTableModel d1= (DefaultTableModel)jTable1.getModel();
        int SelectIndex=jTable1.getSelectedRow();
        b.setTitle((d1.getValueAt(SelectIndex,0).toString()));
        b.setRating(Double.parseDouble(d1.getValueAt(SelectIndex,1).toString()));
        b.setCalories(Integer.parseInt(d1.getValueAt(SelectIndex,2).toString()));
        b.setProtein(Integer.parseInt(d1.getValueAt(SelectIndex,3).toString()));
        b.setFat(Integer.parseInt(d1.getValueAt(SelectIndex,4).toString()));
        b.setSodium(Integer.parseInt(d1.getValueAt(SelectIndex,5).toString()));
        b.setPrice(Integer.parseInt(d1.getValueAt(SelectIndex,6).toString()));
    }

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cos.add(b);
        b=new BaseProduct();
        JOptionPane.showMessageDialog(this,"Produs adaugat");
        tabel_comanda();

    }

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String titlu = titletxt.getText();
        double rating;
        if (ratingtxt.getText().isEmpty())
            rating = -2.0;
        else
            rating = Double.parseDouble(ratingtxt.getText());
        int calories;
        if (caloriestxt.getText().isEmpty())
            calories = -2;
        else
            calories = Integer.parseInt(caloriestxt.getText());

        int prot;
        if (proteintxt.getText().isEmpty())
            prot = -2;
        else
            prot = Integer.parseInt(proteintxt.getText());
        int fat;
        if (fattxt.getText().isEmpty())
            fat = -2;
        else
            fat = Integer.parseInt(fattxt.getText());
        int sodium;
        if (sodiumtxt.getText().isEmpty())
            sodium = -2;
        else
            sodium = Integer.parseInt(sodiumtxt.getText());
        int price;
        if (pricetxt.getText().isEmpty())
            price = -2;
        else
            price = Integer.parseInt(pricetxt.getText());

       ArrayList<MenuItem>p = delivery1.Search(titlu, rating, calories, prot, fat, sodium, price);
        tabel(p);
    }

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.setVisible(false);
        Serializare(delivery1.table);
        ClientView c=new ClientView(id,delivery1);
        c.setVisible(true);
    }

    private void BuyActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if(cos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cos gol");
        return;
        }
        JOptionPane.showMessageDialog(this,"Comanda achitata");
        int ora= Integer.parseInt(jComboBox1.getSelectedItem().toString());
        String data=jTextField1.getText();
        Order o=new Order();
        Random rand= new Random();
        int i=rand.nextInt(1000);
        o.setOrderid(i);
        o.setOrderDate(data);
        o.setHour(ora);
        o.setClientid(id);
ArrayList<MenuItem>M=new ArrayList<>();
Employee_view v=new Employee_view();


int price=0;
for(MenuItem b:cos)
{M.add(b);
price=price+b.getPrice();
}

        FileWriter Log = null;
        try {
            Log = new FileWriter("Bill.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Log.write(o.toString()+"\n");}
        catch (IOException e) {
            e.printStackTrace();
        }
        for(MenuItem b:cos)
        {try {
            Log.write(b.toString()+" ");}
        catch (IOException e) {
            e.printStackTrace();
        }}
            try {
                Log.write("\n"+"Price:"+price);}
            catch (IOException e) {
                e.printStackTrace();

        }
        try {
            Log.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        delivery1.addObserver(employee);
delivery1.AddOrder(o,M);
Serializare(delivery1.table);


        cos.clear();
        tabel_comanda();
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
            java.util.logging.Logger.getLogger(DeliveryService_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliveryService_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliveryService_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DeliveryService_view().setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton Add;
    private javax.swing.JButton Buy;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Search;
    private javax.swing.JLabel calo;
    private javax.swing.JTextField caloriestxt;
    private javax.swing.JLabel fa;
    private javax.swing.JTextField fattxt;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField pricetxt;
    private javax.swing.JTextField proteintxt;
    private javax.swing.JTextField ratingtxt;
    private javax.swing.JLabel sod;
    private javax.swing.JTextField sodiumtxt;
    private javax.swing.JTextField titletxt;
    private javax.swing.JLabel trre;
    // End of variables declaration
}
