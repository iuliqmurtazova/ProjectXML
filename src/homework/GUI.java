package homework;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class GUI extends JFrame{
	public GUI() {
        initComponents();
        init();
    }
    private void init(){
        setTitle("XML Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setSize(530,460);
        setVisible(true);
    }
    private void initComponents() {

        quote = new javax.swing.JLabel();
        button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        checkB = new javax.swing.JCheckBox();
        checkM = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        quote.setBackground(new java.awt.Color(255, 255, 255));
        quote.setFont(new java.awt.Font("Bookman Old Style", 3, 14)); // NOI18N
        quote.setForeground(new java.awt.Color(0, 102, 102));
        quote.setText("Избери опция и изтегли своят цитат! :)");
        quote.setAutoscrolls(true);
        quote.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        quote.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        button.setBackground(new java.awt.Color(0, 102, 102));
        button.setFont(new java.awt.Font("Bookman Old Style", 2, 14)); // NOI18N
        button.setForeground(new java.awt.Color(255, 255, 255));
        button.setText("Изтегли ме");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Здравей любителю на цитатите!");

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 3, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Тук можеш да се наслаждаваш на цитати наволя.");

        checkB.setFont(new java.awt.Font("Bookman Old Style", 3, 12)); // NOI18N
        checkB.setForeground(new java.awt.Color(0, 102, 102));
        checkB.setText("Цитат от книга");

        checkM.setFont(new java.awt.Font("Bookman Old Style", 3, 12)); // NOI18N
        checkM.setForeground(new java.awt.Color(0, 102, 102));
        checkM.setText("Цитат от филм");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkM)
                        .addGap(30, 30, 30)
                        .addComponent(checkB))
                    .addComponent(button)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(quote, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkB)
                    .addComponent(checkM))
                .addGap(18, 18, 18)
                .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(quote, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }                       

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
    	Parcer parcer = new Parcer();
    	
    	try {
			parcer.parceXML();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			JOptionPane.showMessageDialog(null, "Error! Your XML file is missing! Please add it in the folder!");
		}
    
        if(checkB.isSelected() && checkM.isSelected()){
            JOptionPane.showMessageDialog(null, "Грешка!\nИзберете само една опция!");
        }else if (checkM.isSelected()){
            quote.setText("<html>"+parcer.getMovie()+"</html>");
        }else if(checkB.isSelected()){
            quote.setText("<html>"+parcer.getBook()+"</html>");
        }else{
            JOptionPane.showMessageDialog(null, "Моля изберете опция!");
        }
 }                                      
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new GUI();
    }
                        
    private javax.swing.JButton button;
    private javax.swing.JCheckBox checkB;
    private javax.swing.JCheckBox checkM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel quote;
 }
