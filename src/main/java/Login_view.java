/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Login_view extends javax.swing.JFrame {

    ArrayList<Client> clients=new ArrayList<Client>();
DeliveryService delivery=new DeliveryService();

    public Login_view(DeliveryService dd) {
        initComponents();
        Deserializare(delivery.meniu);
        ArrayList<MenuItem>S=new ArrayList<>();
        Deserializare2(S);
        delivery.meniu.addAll(S);
        if(delivery.meniu.isEmpty())
            System.out.println("da");
        delivery.table=Deserializare();
        if(delivery.table.isEmpty())
            System.out.println("da");
        clients=Deserializare_client();
    }

    public Login_view()
    {
        initComponents();
       Deserializare(delivery.meniu);
       ArrayList<MenuItem>S=new ArrayList<>();
       Deserializare2(S);
       delivery.meniu.addAll(S);
       if(delivery.meniu.isEmpty())
           System.out.println("da");
       delivery.table=Deserializare();
       if(delivery.table.isEmpty())
           System.out.println("da");
        clients=Deserializare_client();

        for(Map.Entry<Order, ArrayList<MenuItem>>entry:delivery.table.entrySet())
        {
            Order key=entry.getKey();
            ArrayList<MenuItem> m=entry.getValue();
            System.out.println(key.toString());
            for(MenuItem mm:m)
                System.out.println(mm.getTitle());
        }
    }

    public static void  Serializare(ArrayList<Client> clienti)
    {
        try{
            FileOutputStream fileOut =new FileOutputStream("Clienti.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(clienti);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static ArrayList<Client> Deserializare_client()
    {
        ArrayList<Client> clienti=new ArrayList<Client>();
        try{
            FileInputStream fileIn = new FileInputStream("Clienti.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

           clienti=(ArrayList<Client>)in.readObject();
            in.close();
            fileIn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clienti;
    }

    public static void Serializare(Map<Order,ArrayList<MenuItem>> h)
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


    public Map<Order,ArrayList<MenuItem>> Deserializare()
    {
        Map<Order,ArrayList<MenuItem>>  h=new HashMap<>();
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\HP\\Desktop\\TP teme\\Tema4_tp\\Delivery1.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            h=(Map<Order, ArrayList<MenuItem>>) in.readObject();
            in.close();
            fileIn.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return h;
    }
    public void Deserializare(ArrayList<MenuItem> alimente)
    {
        try{
            FileInputStream fileIn = new FileInputStream("C:\\Users\\HP\\Desktop\\TP teme\\Tema4_tp\\Serializare.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            BaseProduct e;
            while((e=(BaseProduct) in.readObject())!=null)
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

    public void Deserializare2(ArrayList<MenuItem> alimente)
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        passtxt = new javax.swing.JTextField();
        Login = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usertxt = new javax.swing.JTextField();
        wordtxt = new javax.swing.JTextField();
        phonetxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Register = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 0, 255));

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        jLabel5.setText("Phone");

        Register.setText("Register");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(phonetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                                        .addComponent(usertxt)
                                                        .addComponent(wordtxt))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 253, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                        .addComponent(passtxt)
                                        .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(174, 174, 174))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(usertxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(passtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(wordtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(phonetxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addComponent(Register, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(240, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Client c = new Client();
        c.setUsername(usertxt.getText());
        c.setPassword(wordtxt.getText());
        c.setTelefon(phonetxt.getText());
        c.setId(clients.size() + 1);
        int check = 1;
        for (Client aux : clients) {
            if (aux.getUsername().equals(c.getUsername()))
                check = 0;
        }
        if (check == 1)
        {        clients.add(c);
            JOptionPane.showMessageDialog(this,"Client adaugat");
    Serializare(clients);
        }
        else
            JOptionPane.showMessageDialog(this,"Exista un client cu acest nume");
    }

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    String user=nametxt.getText();
    String pass=passtxt.getText();
    int check=0;
    for(Client c:clients)
    {
        if(c.getUsername().equals(user) && c.getPassword().equals(pass))
        {
check=c.getId();
        }
    }
    if(user.equals("admin") && pass.equals("admin"))
    {
       Admin_view ad=new Admin_view(delivery);
       this.setVisible(false);
       ad.setVisible(true);
    }
    else
        if(user.equals("emp") && pass.equals("emp"))
        {
            this.setVisible(false);
            Order_all a=new Order_all("angajat",delivery);
            a.setVisible(true);
        }
        else
if(check!=0)
{
    this.setVisible(false);
    ClientView v=new ClientView(check,delivery);
    v.setVisible(true);
}
    else
    JOptionPane.showMessageDialog(this,"Nu exista acest client ");
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
            java.util.logging.Logger.getLogger(Login_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton Login;
    private javax.swing.JButton Register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nametxt;
    private javax.swing.JTextField passtxt;
    private javax.swing.JTextField phonetxt;
    private javax.swing.JTextField usertxt;
    private javax.swing.JTextField wordtxt;
    // End of variables declaration
}
