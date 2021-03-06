
package mayıntarlası;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import javax.swing.Timer;


public class Expert extends javax.swing.JFrame {
      /*
    -2: sağlam buton
    -1: bombaya sahip buton
     0:  açılmayacak buton
     1 - 8: buton numaraları
    */
    
    final int gen =30 , yük=16 , bomb=99;
    
    JToggleButton[][] blocks = new JToggleButton[yük][gen];
    int [][] block = new int [yük][gen];
    boolean first = false ,canPlay ;
       Timer stopwatch;
    int count = 0;
    int delay = 1000;
    private int mayın;
   
    public Expert() {
        initComponents();
        initComponents();
               initComponents();
        for(int i = 0; i < yük; i++){
            for(int j = 0; j < gen; j++){
                blocks[i][j] = new JToggleButton();
                blocks[i][j].setSize(jPanel1.getWidth()/gen, jPanel1.getHeight()/yük);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/gen, i*jPanel1.getHeight()/yük);
                blocks[i][j].addActionListener(Listen);
            }
            first = false;
            canPlay = true;
        }
    }

    public void startTimer(int countPassed){
        ActionListener action = new ActionListener(){
            public void actionPerformed(ActionEvent e){
              
              lblTimer.setText(""+count);
              count++;
              
            }
        };
        stopwatch = new Timer(delay, action);
        stopwatch.setInitialDelay(0);
        
        count++;
        count = countPassed;
    }
     
    ActionListener Listen = new ActionListener() {
         public void actionPerformed(ActionEvent e){
            int i = 0, j = 0;
            boolean found = false;
            for(i = 0; i < yük; i++){
                for(j = 0; j < gen; j++){
                    if(e.getSource() == blocks[i][j]){
                        found = true;
                        stopwatch.start();
                        break;
                    }
                }
                if(found) break;
            }
            if(canPlay){
                blocks[i][j].setSelected(true);
                if(!first){
                    spawn(i, j);
                    first = true;
                }
                if(block[i][j]!= -1 ){
                    open(i,j);
                    reval();
                } else lose();
                checkWin();
            } else reval();
        }
    };
    
    private void checkWin(){
        boolean won = true;
        for(int i = 0; i < yük; i++){
            for(int j = 0; j < gen; j++){
                if(block[i][j] == 0) {
                    won = false;
                    break;
                }
            }
            if(!won) break;
        }
        if(won){
            javax.swing.JOptionPane.showMessageDialog(null, "You win!!!");
            canPlay=false;
        }
    }
    
    private void lose(){
        canPlay = false;
        for(int i = 0; i < yük; i++){
            for(int j = 0; j < gen; j++){
                if(block[i][j] == -1) {
                    blocks[i][j].setText("BOOM");
                    blocks[i][j].setSelected(true);
                    count =0;stopwatch.stop();
                }
            }
        }
    }
    
    private void open(int y, int x){
        if(y < 0 || x < 0 || x > gen - 1 || y > yük - 1 || block[y][x] != 0) return;
        int bombs = 0;
        for(int i = y - 1; i <= y + 1;i++){
            for(int j = x - 1; j <= x + 1;j++){
                if(!(j < 0 || i < 0 || j > gen - 1 || i > yük - 1) && block[i][j] == -1)
                    bombs++;
            }
        }
        if(bombs == 0){
            block[y][x] = -2;
            for(int i = y - 1; i <= y + 1;i++){
                for(int j = x - 1; j <= x + 1;j++){
                    if(!(j < 0 || i < 0 || j > gen - 1 || i > yük - 1))
                    if(i != y || j != x) open(i,j);
                }
            }
        } else block[y][x] = bombs;
    }
     
    private void spawn(int y, int x){
        for(int k = 1; k <= bomb;k++){
            int i, j;
            do{
                i = (int)(Math.random()*(gen-.01));
                j = (int)(Math.random()*(yük-.01));
            }
            while(block[i][j] == -1 || (i == y && j == x));
            block[i][j] = -1;
            
    }}
    
    private void resiz(){
        for(int i = 0; i < yük; i++){
            for(int j = 0; j < gen; j++){
                blocks[i][j].setSize(jPanel1.getWidth()/gen, jPanel1.getHeight()/yük);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/gen, i*jPanel1.getHeight()/yük);
            }
        }
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTimer = new javax.swing.JLabel();
        Restart = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Beginner = new javax.swing.JMenuItem();
        İntermediate = new javax.swing.JMenuItem();
        Expert = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );

        lblTimer.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N

        Restart.setText("Restart");
        Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartActionPerformed(evt);
            }
        });

        jMenu1.setText("Game");

        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        jMenu1.add(New);
        jMenu1.add(jSeparator1);

        Beginner.setText("Beginner");
        Beginner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeginnerActionPerformed(evt);
            }
        });
        jMenu1.add(Beginner);

        İntermediate.setText("İntermediate");
        İntermediate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                İntermediateActionPerformed(evt);
            }
        });
        jMenu1.add(İntermediate);

        Expert.setText("Expert");
        Expert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpertActionPerformed(evt);
            }
        });
        jMenu1.add(Expert);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 754, Short.MAX_VALUE)
                        .addComponent(Restart)
                        .addGap(683, 683, 683)
                        .addComponent(lblTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Restart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        resiz();
        startTimer(0);
    }//GEN-LAST:event_jPanel1ComponentResized

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        block = new int[yük][gen];
        reval();
        canPlay = true;
        first = false;
    }//GEN-LAST:event_NewActionPerformed

    private void ExpertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpertActionPerformed
       block = new int[yük][gen];
        reval();
        canPlay = true;
        first = false;
    }//GEN-LAST:event_ExpertActionPerformed

    private void İntermediateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_İntermediateActionPerformed
        İntermediate in = new İntermediate();
        in.show();
        this.hide();
    }//GEN-LAST:event_İntermediateActionPerformed

    private void BeginnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeginnerActionPerformed
        mayın mn = new mayın();
        mn.show();
        this.hide();
    }//GEN-LAST:event_BeginnerActionPerformed

    private void RestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartActionPerformed
         block = new int[yük][gen];
        reval();
        canPlay = true;
        first = false;
    }//GEN-LAST:event_RestartActionPerformed

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
            java.util.logging.Logger.getLogger(Expert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Expert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Expert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Expert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Expert().setVisible(true);
            }
        });
    }
     
     private void reval(){
        for(int i = 0; i < yük; i++){
            for(int j = 0; j < gen; j++){
                if(block[i][j] == 0){
                    blocks[i][j].setText("");
                    blocks[i][j].setSelected(false);

                }
                if(block[i][j] == -2){
                    blocks[i][j].setText("");
                    blocks[i][j].setSelected(true);
                }
                if(block[i][j] > 0){
                    blocks[i][j].setText(""+block[i][j]);
                    blocks[i][j].setSelected(true);
                }
                if(!canPlay && block[i][j] == -1) blocks[i][j].setSelected(true);
            }
        }
        jPanel1.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Beginner;
    private javax.swing.JMenuItem Expert;
    private javax.swing.JMenuItem New;
    private javax.swing.JButton Restart;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblTimer;
    private javax.swing.JMenuItem İntermediate;
    // End of variables declaration//GEN-END:variables
}
