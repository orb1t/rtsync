/**
 * Copyright (C) 2012 SINTEF <franck.fleurey@sintef.no>
 *
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3, 29 June 2007;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingml.rtsync.ui;

import java.io.File;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import org.thingml.rtsync.core.*;

/**
 *
 * @author ffl
 */
public class TimeSyncFrame extends javax.swing.JFrame implements ITimeSynchronizerLogger {

    JFileChooser chooser = new JFileChooser();
    Preferences prefs = Preferences.userRoot().node(this.getClass().getName());
    
    protected TimeSynchronizer ts;
    
    protected TimeSynchronizerPrintLogger tspl = new TimeSynchronizerPrintLogger();
    protected TimeSynchronizerFileLogger tsfl = new TimeSynchronizerFileLogger();
    /**
     * Creates new form TimeSyncFrame
     */
    public TimeSyncFrame(TimeSynchronizer ts) {
        this.ts = ts;
        ts.addLogger(this);
        ts.addLogger(tsfl);
        initComponents();
        chooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        jTextFieldLogDir.setText(prefs.get("TSLogFolder", ""));
        jButtonStartLog.setEnabled(true);
        jButtonEndLog.setEnabled(false);
        populateFields();
        if (ts.isRunning()) {
            configRunning();
        }
        else {
            configStopped();
        }
    }
    
    void configRunning() {
        disableEdit();
        jTextFieldStatus.setText("Running...");
        jButtonStart.setEnabled(false);
        jButtonStop.setEnabled(true);
    }
    
    void configStopped() {
        enableEdit();
        jTextFieldStatus.setText("Stopped.");
        jButtonStart.setEnabled(true);
        jButtonStop.setEnabled(false);
    }
    

    void populateFields() {
        jTextFieldKInt.setText(""+ts.getkInt());
        jTextFieldPingRate.setText(""+ts.getPingRate());
        jTextFieldPingseqMax.setText(""+ts.getPingSeqMax());
        jTextFieldTSErrMax.setText(""+ts.getTsErrorMax());
        jTextFieldTSMax.setText(""+ts.getTs_maxvalue());
        jTextFieldTSPhase.setText(""+ts.getTs_phase_frame());
        jTextFieldZeroAvgsize.setText(""+ts.getZeroOffsetAvgSize());
        jTextFielddTsmax.setText(""+ts.getdTsDeltaMax());
    }
    
    void readFields() {
        ts.setkInt(Integer.parseInt(jTextFieldKInt.getText()));
        ts.setPingRate(Integer.parseInt(jTextFieldPingRate.getText()));
        ts.setPingSeqMax(Integer.parseInt(jTextFieldPingseqMax.getText()));
        ts.setTsErrorMax(Integer.parseInt(jTextFieldTSErrMax.getText()));
        ts.setTs_phase_frame(Integer.parseInt(jTextFieldTSPhase.getText()));
        ts.setZeroOffsetAvgSize(Integer.parseInt(jTextFieldZeroAvgsize.getText()));
        ts.setdTsDeltaMax(Integer.parseInt(jTextFielddTsmax.getText()));
    }
    
    void enableEdit() {
        jTextFieldKInt.setEditable(true);
        jTextFieldPingRate.setEditable(true);
        jTextFieldPingseqMax.setEditable(true);
        jTextFieldTSErrMax.setEditable(true);
        jTextFieldTSMax.setEditable(false);
        jTextFieldTSPhase.setEditable(true);
        jTextFieldZeroAvgsize.setEditable(true);
        jTextFielddTsmax.setEditable(true);
    }
    
    void disableEdit() {
        jTextFieldKInt.setEditable(false);
        jTextFieldPingRate.setEditable(false);
        jTextFieldPingseqMax.setEditable(false);
        jTextFieldTSErrMax.setEditable(false);
        jTextFieldTSMax.setEditable(false);
        jTextFieldTSPhase.setEditable(false);
        jTextFieldZeroAvgsize.setEditable(false);
        jTextFielddTsmax.setEditable(false);
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPingRate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPingseqMax = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldZeroAvgsize = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldKInt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFielddTsmax = new javax.swing.JTextField();
        jTextFieldTSErrMax = new javax.swing.JTextField();
        jTextFieldTSMax = new javax.swing.JTextField();
        jTextFieldTSPhase = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButtonPingCharts = new javax.swing.JButton();
        jButtonErrorCharts = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldLogDir = new javax.swing.JTextField();
        jButtonBrowse = new javax.swing.JButton();
        jCheckBoxConsole = new javax.swing.JCheckBox();
        jButtonEndLog = new javax.swing.JButton();
        jButtonStartLog = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jButtonStop = new javax.swing.JButton();
        jButtonStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Ping Rate:");

        jLabel2.setText("Max Ping Seq:");

        jLabel3.setText("# Init Samples:");

        jLabel4.setText("kInt:");

        jLabel5.setText("dTsDeltaMax:");

        jLabel6.setText("tsErrorMax:");

        jLabel7.setText("ts_maxvalue:");

        jLabel8.setText("ts_phase_frame:");

        jButtonPingCharts.setText("Ping charts...");
        jButtonPingCharts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPingChartsActionPerformed(evt);
            }
        });

        jButtonErrorCharts.setText("Error charts...");
        jButtonErrorCharts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonErrorChartsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonErrorCharts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPingCharts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonPingCharts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonErrorCharts)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldPingseqMax)
                    .addComponent(jTextFieldZeroAvgsize)
                    .addComponent(jTextFieldKInt, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jTextFieldPingRate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFielddTsmax)
                    .addComponent(jTextFieldTSErrMax)
                    .addComponent(jTextFieldTSMax)
                    .addComponent(jTextFieldTSPhase, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldPingRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFielddTsmax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPingseqMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTSErrMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldZeroAvgsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldTSMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldKInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldTSPhase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setText("Log directory:");

        jButtonBrowse.setText("Browse...");
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });

        jCheckBoxConsole.setText("Console log");
        jCheckBoxConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxConsoleActionPerformed(evt);
            }
        });

        jButtonEndLog.setText("End log");
        jButtonEndLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndLogActionPerformed(evt);
            }
        });

        jButtonStartLog.setText("Begin log");
        jButtonStartLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldLogDir))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBoxConsole)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                        .addComponent(jButtonStartLog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEndLog)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBrowse)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldLogDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxConsole)
                    .addComponent(jButtonEndLog)
                    .addComponent(jButtonStartLog))
                .addContainerGap())
        );

        jLabel10.setText("Time Sync. status:");

        jButtonStop.setText("Stop");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStop)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonStop)
                    .addComponent(jButtonStart))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
        File folder = new File(jTextFieldLogDir.getText());
    if (folder.exists() && folder.isDirectory()) chooser.setSelectedFile(folder);
    if (chooser.showDialog(this, "OK") == JFileChooser.APPROVE_OPTION) {
        jTextFieldLogDir.setText(chooser.getSelectedFile().getAbsolutePath());
        prefs.put("TSLogFolder", folder.getAbsolutePath());
    }
    }//GEN-LAST:event_jButtonBrowseActionPerformed

    private void jCheckBoxConsoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxConsoleActionPerformed
        if (jCheckBoxConsole.isSelected()) {
            ts.addLogger(tspl);
        }
        else {
            ts.removeLogger(tspl);
        }
    }//GEN-LAST:event_jCheckBoxConsoleActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        if (!ts.isRunning()) {
            try {
                readFields();
                populateFields();
                ts.start_timesync();
                configRunning();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
        if (ts.isRunning()) {
            try {
                ts.stop_timesync();
                configStopped();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButtonPingChartsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPingChartsActionPerformed
        TimeSyncPingFrame timeframe = new TimeSyncPingFrame(ts);
        timeframe.setSize(400, 500);
        timeframe.setVisible(true);
    }//GEN-LAST:event_jButtonPingChartsActionPerformed

    private void jButtonErrorChartsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonErrorChartsActionPerformed
        TimeSyncErrorFrame errframe = new TimeSyncErrorFrame(ts);
        errframe.setSize(400, 600);
        errframe.setVisible(true);
    }//GEN-LAST:event_jButtonErrorChartsActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ts.removeLogger(tspl);
        ts.removeLogger(tsfl);
        ts.removeLogger(this);
    }//GEN-LAST:event_formWindowClosed

    private void jButtonStartLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartLogActionPerformed
        File folder = new File(jTextFieldLogDir.getText());
        if (!folder.exists() || !folder.isDirectory()) {
            if (chooser.showDialog(this, "OK") == JFileChooser.APPROVE_OPTION) {
                jTextFieldLogDir.setText(chooser.getSelectedFile().getAbsolutePath());
                folder = chooser.getSelectedFile();
            }
            else return; // abort
        }
        prefs.put("TSLogFolder", folder.getAbsolutePath());
        tsfl.start_logging(folder);
        jButtonStartLog.setEnabled(false);
        jButtonEndLog.setEnabled(true);
    }//GEN-LAST:event_jButtonStartLogActionPerformed

    private void jButtonEndLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEndLogActionPerformed
        if (tsfl.isLogging()) {
            tsfl.stop_logging();
            jButtonStartLog.setEnabled(true);
            jButtonEndLog.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonEndLogActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JButton jButtonEndLog;
    private javax.swing.JButton jButtonErrorCharts;
    private javax.swing.JButton jButtonPingCharts;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStartLog;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JCheckBox jCheckBoxConsole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldKInt;
    private javax.swing.JTextField jTextFieldLogDir;
    private javax.swing.JTextField jTextFieldPingRate;
    private javax.swing.JTextField jTextFieldPingseqMax;
    private javax.swing.JTextField jTextFieldStatus;
    private javax.swing.JTextField jTextFieldTSErrMax;
    private javax.swing.JTextField jTextFieldTSMax;
    private javax.swing.JTextField jTextFieldTSPhase;
    private javax.swing.JTextField jTextFieldZeroAvgsize;
    private javax.swing.JTextField jTextFielddTsmax;
    // End of variables declaration//GEN-END:variables

    @Override
    public void timeSyncStart() {
        
    }

    @Override
    public void timeSyncReady() {
        
    }

    @Override
    public void timeSyncStop() {
        
    }

    @Override
    public void timeSyncWrongSequence(int pingSeqNum, int pongSeqNum) {
        
    }

    @Override
    public void timeSyncPong(int delay, int dtt, int dtr, int dts) {
        
    }

    @Override
    public void timeSyncDtsFilter(int dts) {
        
    }

    @Override
    public void timeSyncErrorFilter(int error) {
        
    }

    @Override
    public void timeSyncLog(String time, long ts, long tmt, long tmr, long delay, long offs, long errorSum, long zeroOffset, long regOffsMs, int skipped) {
        
    }
}