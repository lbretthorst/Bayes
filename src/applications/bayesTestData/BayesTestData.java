/*
 * AnalyzeImagePixels.java
 *
 * Created on November 17, 2008, 11:36 AM
 */

package applications.bayesTestData;
import ascii.AsciiIO;
import image.ImageIO;
import bayes.Reset;
import bayes.ParameterPrior;
import bayes.PackageManager;
import bayes.WriteBayesParams;
import bayes.JobDirections;
import bayes.BayesManager;
import bayes.DirectoryManager;
import applications.model.EnterAsciiPackage;
import run.JRun;
import java.util.List;
import applications.model.ImageModel;
import bayes.BayesView;
import javax.swing.*;
import java.io.*;
import utilities.*;
import interfacebeans.*;
import load.*;
import bayes.Enums.*;
import interfacebeans.AllViewers;
import image.ImageViewer;
import image.ImageDescriptor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import load.LoadAsciiModels.*;
/**
 *
 * @author  apple
 */
public class BayesTestData extends javax.swing.JPanel
        implements ImageModel,
                    EnterAsciiPackage,
                        java.beans.PropertyChangeListener {

    /** Creates new form AnalyzeImagePixels */
    public BayesTestData() {
        LoadPackage.loadPackage(this);
        PackageManager.setCurrentApplication(this);
        
        AllViewers.addCodeViewer();
        boolean isDeseralized = bayes.Serialize. deserializeCurrenExperiment();
        
        initComponents();
        
        BayesManager.pcs.addPropertyChangeListener(this);
        JShowModels.getInstance().addPropertyChangeListener(this);
        ImageViewer.getInstance().addPropertyChangeListener(this);

        
        if(isDeseralized){
            AllViewers.showImageViewer();
            JRun.fireJobIDChange();
        }
        else { AllViewers.showInstructions();}
        generateLoadMessage( );
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tools = new javax.swing.JPanel();
        jRun = new run.JRun();
        processSlice = new javax.swing.JPanel();
        startLabel = new javax.swing.JLabel();
        startFormatetedTextField = new javax.swing.JFormattedTextField();
        endLabel = new javax.swing.JLabel();
        endFormattedTextField = new javax.swing.JFormattedTextField();
        jserver = interfacebeans.JServer.getInstance();
        jPanel2 = new javax.swing.JPanel();
        jSystemModel = new javax.swing.JButton();
        jUserModel = new javax.swing.JButton();
        buildModelButton = new javax.swing.JButton();
        savePriorsButton = new javax.swing.JButton();
        jResetSave = new interfacebeans.JResetSave();
        graph_panel = AllViewers.getInstance ();

        FormListener formListener = new FormListener();

        setPreferredSize(new java.awt.Dimension(1100, 800));
        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(140);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setName("jSplitPane1"); // NOI18N
        jSplitPane1.setOneTouchExpandable(true);

        jScrollPane1.setBorder(null);
        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tools.setFocusCycleRoot(true);
        tools.setName("tools"); // NOI18N

        jRun.setName("jRun"); // NOI18N

        processSlice.setBorder(javax.swing.BorderFactory.createTitledBorder("Process Slice"));
        processSlice.setName("processSlice"); // NOI18N
        processSlice.setLayout(new java.awt.GridLayout(2, 4, 0, 6));

        startLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        startLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        startLabel.setText("  Start");
        startLabel.setName("startLabel"); // NOI18N
        processSlice.add(startLabel);

        startFormatetedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0"))));
        startFormatetedTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        startFormatetedTextField.setToolTipText("<html><p style=\"margin: 6px;\"><font size=\"4\">\n\nEnter the first slice to be processed.<br>\nThe default is 1.\n\n</font></p><html>\n\n"); // NOI18N
        startFormatetedTextField.setInputVerifier(new PositiveIntegerInputVerifier());
        startFormatetedTextField.setName("startFormatetedTextField"); // NOI18N
        startFormatetedTextField.setValue(startSliceIndex);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${startSliceIndex}"), startFormatetedTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        startFormatetedTextField.addPropertyChangeListener(formListener);
        processSlice.add(startFormatetedTextField);

        endLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        endLabel.setText("  End");
        endLabel.setName("endLabel"); // NOI18N
        processSlice.add(endLabel);

        endFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0"))));
        endFormattedTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        endFormattedTextField.setToolTipText("<html><p style=\"margin: 6px;\"><font size=\"4\">\n\nEnter the last slice to process. <br>\nThe default is the number of slices.\n\n</font></p><html>\n\n"); // NOI18N
        endFormattedTextField.setInputVerifier(new PositiveIntegerInputVerifier());
        endFormattedTextField.setName("endFormattedTextField"); // NOI18N
        endFormattedTextField.setValue(endSliceIndex);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${endSliceIndex}"), endFormattedTextField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        endFormattedTextField.addPropertyChangeListener(formListener);
        processSlice.add(endFormattedTextField);

        jserver.setName("jserver"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Load and Build Model"));
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jSystemModel.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        jSystemModel.setText("  System   ");
        jSystemModel.setToolTipText("<html><p style=\"margin: 6px;\"><font size=\"4\">\n\nLoad model from system directory.\n\n\n</font></p><html>\n\n\n"); // NOI18N
        jSystemModel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jSystemModel.setName("jSystemModel"); // NOI18N
        jSystemModel.setPreferredSize(new java.awt.Dimension(125, 25));
        jSystemModel.addActionListener(formListener);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jSystemModel, gridBagConstraints);

        jUserModel.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        jUserModel.setText("User ");
        jUserModel.setToolTipText("<html><p style=\"margin: 6px;\"><font size=\"4\">\n\nLoad model from user directory.\n\n\n</font></p><html>\n\n"); // NOI18N
        jUserModel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jUserModel.setName("jUserModel"); // NOI18N
        jUserModel.setPreferredSize(new java.awt.Dimension(125, 25));
        jUserModel.addActionListener(formListener);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(jUserModel, gridBagConstraints);

        buildModelButton.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        buildModelButton.setText("Build");
        buildModelButton.setToolTipText("<html><p style=\"margin: 6px;\"><font size=\"4\">\n\n\nBuild (compile) model.\n\n\n</font></p><html>\n\n\n"); // NOI18N
        buildModelButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        buildModelButton.setName("buildModelButton"); // NOI18N
        buildModelButton.setPreferredSize(new java.awt.Dimension(120, 25));
        buildModelButton.addActionListener(formListener);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(buildModelButton, gridBagConstraints);

        savePriorsButton.setFont(new java.awt.Font("Lucida Grande", 1, 13));
        savePriorsButton.setText("Save priors");
        savePriorsButton.setToolTipText("<html><p style=\"margin: 6px;\"><font size=\"4\">\n\nSave current prior settings.\n\n\n</font></p><html>\n\n"); // NOI18N
        savePriorsButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        savePriorsButton.setName("savePriorsButton"); // NOI18N
        savePriorsButton.setPreferredSize(new java.awt.Dimension(125, 25));
        savePriorsButton.addActionListener(formListener);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jPanel2.add(savePriorsButton, gridBagConstraints);

        jResetSave.setName("jResetSave"); // NOI18N

        org.jdesktop.layout.GroupLayout toolsLayout = new org.jdesktop.layout.GroupLayout(tools);
        tools.setLayout(toolsLayout);
        toolsLayout.setHorizontalGroup(
            toolsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(toolsLayout.createSequentialGroup()
                .add(15, 15, 15)
                .add(jRun, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 199, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jserver, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 245, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(processSlice, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jResetSave, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(605, Short.MAX_VALUE))
        );
        toolsLayout.setVerticalGroup(
            toolsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jRun, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(processSlice, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
            .add(jserver, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
            .add(toolsLayout.createSequentialGroup()
                .add(jResetSave, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        toolsLayout.linkSize(new java.awt.Component[] {jPanel2, jResetSave, jRun, jserver, processSlice}, org.jdesktop.layout.GroupLayout.VERTICAL);

        jScrollPane1.setViewportView(tools);

        jSplitPane1.setTopComponent(jScrollPane1);

        graph_panel.setName("graph_panel"); // NOI18N
        graph_panel.setLayout(new javax.swing.BoxLayout(graph_panel, javax.swing.BoxLayout.LINE_AXIS));
        jSplitPane1.setRightComponent(graph_panel);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.beans.PropertyChangeListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == jSystemModel) {
                BayesTestData.this.jSystemModelActionPerformed(evt);
            }
            else if (evt.getSource() == jUserModel) {
                BayesTestData.this.jUserModelActionPerformed(evt);
            }
            else if (evt.getSource() == buildModelButton) {
                BayesTestData.this.buildModelButtonActionPerformed(evt);
            }
            else if (evt.getSource() == savePriorsButton) {
                BayesTestData.this.savePriorsButtonActionPerformed(evt);
            }
        }

        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            if (evt.getSource() == startFormatetedTextField) {
                BayesTestData.this.startFormatetedTextFieldPropertyChange(evt);
            }
            else if (evt.getSource() == endFormattedTextField) {
                BayesTestData.this.endFormattedTextFieldPropertyChange(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

private void jSystemModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSystemModelActionPerformed
        JShowModels.getInstance().loadSysModel();
        clearPreviousRun();
}//GEN-LAST:event_jSystemModelActionPerformed
private void jUserModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserModelActionPerformed
         JShowModels.getInstance().loadUserModel();
         clearPreviousRun();
}//GEN-LAST:event_jUserModelActionPerformed
private void buildModelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildModelButtonActionPerformed
        JShowModels.getInstance().build();
        clearPreviousRun();
}//GEN-LAST:event_buildModelButtonActionPerformed
private void savePriorsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePriorsButtonActionPerformed
if(     getAsciiModel().isLoaded() == false){
            setMessage(getAsciiModel().getName() + ". "+"You cannot save the priors  until you load a model");
            return;
       }
       
       savePriors();
}//GEN-LAST:event_savePriorsButtonActionPerformed
private void startFormatetedTextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_startFormatetedTextFieldPropertyChange
    if (evt.getPropertyName().equalsIgnoreCase("value") == false) {return;}
     int val = ((Number)startFormatetedTextField.getValue()).intValue();
     setStartSliceIndex( val);
     clearPreviousRun();
}//GEN-LAST:event_startFormatetedTextFieldPropertyChange
private void endFormattedTextFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_endFormattedTextFieldPropertyChange
    if (evt.getPropertyName().equalsIgnoreCase("value") == false) {return;}
    int val = ((Number)endFormattedTextField.getValue()).intValue();
    setEndSliceIndex ( val);
    clearPreviousRun();
}//GEN-LAST:event_endFormattedTextFieldPropertyChange
    
    public void              propertyChange(java.beans.PropertyChangeEvent evt){
      if (evt.getPropertyName().equals(bayes.BayesManager.JRUN_JOB_START)){
          setActive(false);
          setMessage(message);
      }
      
      else if (evt.getPropertyName().equals(bayes.BayesManager.JRUN_JOB_END)){
         setActive(true);
         ImageViewer.getInstance().updateImageList();
         AllViewers.showImageViewer();
      }
      
      else if (evt.getPropertyName().equals(bayes.BayesManager.JRUN_JOB_CANCELED)){
           setActive(true);
      }
    
   
     else if (evt.getPropertyName().equals(JShowModels.COMPILE_IS_RUN)){
          generateLoadMessage( );
     }

     else if (evt.getPropertyName().equals(bayes.BayesManager.COMPILE_ERRROR)){
          EnterAsciiModel.updateModelBuilt(getAsciiModel());

          generateLoadMessage( );

          String error = evt.getNewValue().toString();
          DisplayText.popupErrorMessage(error);
      }
      else if (evt.getPropertyName().equals(ImageViewer.IMAGE_HAS_BEEN_LOADED)){
       // ImageDescriptor id = (ImageDescriptor )evt.getNewValue();
      }
      
      else if (evt.getPropertyName() .equals(JShowModels.NO_ASCII_MODEL_LOADED)){
             setMessage( EnterAsciiModel.NOT_LOADED_MESSAGE);

             AllViewers.showCodeViewer();
      }
      
      else if (evt.getPropertyName() .equals( JShowModels.ASCII_MODEL_IS_LOADED)){
           AsciiIO.clearAsciiFileNonCompatibleWithModel(this);
           generateLoadMessage( );

           AllViewers.showCodeViewer();
      }
      
   
   }
    public void              setPackageParameters(ObjectInputStream ois) throws Exception{
         EnterAsciiModel theModel           =   (EnterAsciiModel)ois.readObject();
         String     msg                     =   (String)ois.readObject();
         int        start                   =   (Integer)ois.readObject();
         int        end                     =   (Integer)ois.readObject();
         double     sdev                    =   (Double)ois.readObject();
         boolean    isMaxL                  =   (Boolean)ois.readObject();
         boolean    useGaus                 =   (Boolean)ois.readObject();
         boolean    isOultiers              =   (Boolean)ois.readObject();
         this.setMessage( msg);
         this.setStartSliceIndex(start);
         this.setEndSliceIndex(end);
       
         JShowModels.getInstance().addModel(theModel);
        
     
       
    }
    public void              savePackageParameters(ObjectOutputStream oos){
        try{
             oos.writeObject( getAsciiModel());
             oos.writeObject(message);
             oos.writeObject(this.getStartSliceIndex());
             oos.writeObject(this.getEndSliceIndex());
           
             
        } catch (IOException exp){
             DirectoryManager.getSerializationFile().delete();
             exp.printStackTrace();
       }        
    }    
    public boolean           isReadyToRun(){
      // make sure data has been loaded
       File dir        =   DirectoryManager.getBayesOtherAnalysisDir();


       // make sure the asciiModel has been loaded
       if(getAsciiModel().isLoaded() == false){
           DisplayText.popupMessage("Model is not loaded.");
           return false;
       }
         // make sure the asciiModel has been built
       if(getAsciiModel().isBuilt() == false){
           DisplayText.popupErrorMessage(
                "Before you can run the analysis, \n" +
                "you must verify the model is error free \n" +
                "using the \"Build Model\" button.");
          return false;
       }



       // write the parameter file
       boolean bl  =  WriteBayesParams.writeParamsFile(this, dir);
       if (bl == false){
           DisplayText.popupMessage( "Failed to write Bayes.params file.");
           return false;
       }

       // save the priors
       savePriors();

       //  write "job.directions" file
       bl  =  JobDirections.writeFromProperties(JobDirections.BAYES_SUBMIT_IMAGE);
       if(bl == false){
          DisplayText.popupMessage("Failed to write job.directions file.");
          return false;
        }
        return true;
    }
    public String            getProgramName(){
         return "BayesTestData";
     
    }
    public String            getExtendedProgramName() { return "Bayes Test Data" ;}
    public int               getNumberOfAbscissa(){
        if(getAsciiModel().isLoaded()){   return getAsciiModel().getNumberOfAbscissa();}
        else  { return 0;}
    }
    public int               getNumberOfDataColumns(){
         if(getAsciiModel().isLoaded())  {  
             return getAsciiModel().getNumberOfDataCols();}
         
         /*make sure default is 1. Otherwise extracted image pixel
          *in the absense of loaded model, won't display
          */
         else                       {return 1 ;}
    }
    public int               getTotalNumberOfColumns(){
        int curNoCols = getNumberOfDataColumns();
        int curNoAbs  = getNumberOfAbscissa();
        int noOfCols;
        if(curNoAbs == 1){
            noOfCols = curNoAbs + curNoCols;
        } else{
            noOfCols = 1 + curNoAbs + curNoCols;
        }
        return noOfCols;}
    public int               getNumberOfPriors(){return  getAsciiModel().getNumberOfPriors();}
    public StringBuilder     getModelSpecificsForParamsFile(int PADLEN, String PADCHAR){
        StringBuilder sb            =   new StringBuilder();
        String  EOL                 =   BayesManager.EOL; // end of line character
        String  separator           =   BayesManager.FILE_SEPARATOR; // file separator
        ImageViewer iv              =   ImageViewer.getInstance();
        File imgDir                 =   DirectoryManager.getImageDir();
        List <File>imageFiles       =   iv.getSelectedFiles();
        String str                  =   null;

        // sort lexicographically
        Collections.sort(imageFiles );

        int noParams    = 10 +  getAsciiModel().getNumberOfDerived();
        sb.append( IO.pad("Package Parameters", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(noParams); 
        sb.append(EOL);

        int numberOfImages          =   imageFiles.size();
        sb.append( IO.pad("Number Of Input Images", -PADLEN, PADCHAR ));
        sb.append(" = ") ;
        sb.append(numberOfImages);
        sb.append(EOL);

        for (File file : imageFiles) {
            str  = imgDir.getName()+ separator +  file.getName() ;
            sb.append( IO.pad("Input Image Name", -PADLEN, PADCHAR ));
            sb.append(" = ") ;
            sb.append(str);
            sb.append(EOL);
        }
 
       
        
        str     = imgDir.getName() ;
        sb.append( IO.pad("Output Image Directory", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(str); 
        sb.append(EOL); 
        
        sb.append( IO.pad("NoRo", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(10); 
        sb.append(EOL); 
        
        
        sb.append( IO.pad("NoPe", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(10); 
        sb.append(EOL);
    
        
        sb.append( IO.pad("ArrayDim", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(64); 
        sb.append(EOL);
        
        sb.append( IO.pad("No Slices", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(1); 
        sb.append(EOL);
        
        
        sb.append( IO.pad("Starting Slice", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(1); 
        sb.append(EOL);
        
        sb.append( IO.pad("Ending Slice", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(1); 
        sb.append(EOL);
        
        sb.append( IO.pad("Noise Std Dev", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(0.5); 
        sb.append(EOL);
        
        sb.append( IO.pad("Use Gaussian", -PADLEN, PADCHAR ));
        sb.append(" = ") ;
        sb.append("No");
        sb.append(EOL);
        
        sb.append( IO.pad("Use ROI", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append("No"); 
        sb.append(EOL);
        
        sb.append( IO.pad("Abscissa", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(getAbscissa()); 
        sb.append(EOL);
        
        
        sb.append( IO.pad("Maximum Abscissa Value", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(""+getMaxAbacissaValue()); 
        sb.append(EOL);
        
        str     =  this.getAsciiModelName() ;
        sb.append( IO.pad("Model Name", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(str); 
        sb.append(EOL); 
         
        sb.append( IO.pad("Number Of Models", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append(getAsciiModel().getNumberOfModelVectors()); 
        sb.append(EOL); 
         
        
        sb.append( IO.pad("Number of Derived", -PADLEN, PADCHAR )); 
        sb.append(" = ") ;
        sb.append( getAsciiModel().getNumberOfDerived()); 
        sb.append(EOL); 
       
         String [] Derived =  getAsciiModel().getDerived();;
         for (int I = 0; I < Derived.length; I++) {
             int ind = I+1;
             sb.append( IO.pad("Derived "+ ind, -PADLEN, PADCHAR )); 
             sb.append(" = ") ;
             sb.append(Derived[I]); 
             sb.append(EOL); 
         }
     
         return sb;
     
    };
    public List <ParameterPrior>  getPriors() {
        return getAsciiModel().getPriors();
    }
    public String            getConstructorArg(){ return getAsciiModelName();}
    public String            getInstructions(){return PACKAGE_INTSRUCTIONS.BAYES_TEST_DATA.getInstruction();}
    public boolean           isOutliers(){ return false;}
    public void              setActive(boolean isActive){
          jSystemModel.setEnabled(isActive);
          jUserModel.setEnabled(isActive);
          getSavePriorsButton().setEnabled(isActive);
          getBuildModelButton().setEnabled(isActive);
          jserver.setActive(isActive);
          jRun.setEnabled(isActive);
          jResetSave.setActive(isActive);

          getEndFormattedTextField().setEditable(isActive);
          getStartFormatetedTextField().setEnabled(isActive);
          getEndFormattedTextField ().setEnabled(isActive);
          startLabel.setEnabled(isActive);
          endLabel.setEnabled(isActive);

          AllViewers.getInstance().setActive(isActive);
    }
    public void              reset(){

            JShowModels.getInstance().removeAllModels();
            generateLoadMessage( );
            LoadAsciiModels.cleanModelFiles();

            setDefaults();

            clearPreviousRun();


            // show default viewer
            AllViewers.getInstance().showDefaultViewer();
       
    }
    @Override
    public void              clearPreviousRun(){

          Reset.clearImageResutls();

         // reset job status
         jRun.reset();

    }
    public void              setDefaults(){
        getStartFormatetedTextField().setValue(1);
        getEndFormattedTextField ().setValue(ImageViewer.getInstance().getNSlices());
        setMessage("");

    }
    public Collection <File> getFilesToTar(){
       
        List<File> tarFiles     =   new  ArrayList<File>();
        File imageDir = DirectoryManager.getImageDir();
        if(!imageDir.exists()){
            imageDir.mkdirs();
        }
        tarFiles.add(DirectoryManager.getBayesOtherAnalysisDir()); // asciiDIR
        tarFiles.add(imageDir);
   
        return tarFiles ;
    }
   
    
    public void             savePriors(){
        getAsciiModel().overwriteOriginalParamsFile();
        setMessage(getAsciiModel().getName() + ". "+"Priors have been saved"); 
      
    }   
    protected void          generateLoadMessage( ) {
        String msg      = getAsciiModel().getStatusMessage();
        setMessage(msg);
    }


     public boolean verifyProcessSlices( Collection<File> imageFiles){

      String error                   =   null;
         if (getStartSliceIndex() < 1){
               error               =   String.format(
                    "Start slice number (%s) must be larger than 0\n"
                    + "Exiting...", getStartSliceIndex());

            DisplayText.popupErrorMessage(error);
            return false;
        }
        if (getEndSliceIndex() < 1){
               error               =   String.format(
                    "End slice number (%s) must be larger than 0\n"
                    + "Exiting...", getStartSliceIndex());

            DisplayText.popupErrorMessage(error);
            return false;
        }

        if (getEndSliceIndex() < getStartSliceIndex()){
               error               =   String.format(
                    "End slice number (%s) must be larger than\n"
                    + "start slice number (%s))"
                    + "Exiting...", getEndSliceIndex(), getStartSliceIndex());

            DisplayText.popupErrorMessage(error);
            return false;
        }

         for (File file : imageFiles) {
             boolean isvalid = verifyProcessSlices(file);
             if (isvalid){continue;}
             else{ return false;}
         }


      return true;

     }
     public boolean verifyProcessSlices(File  imgfile){
         String error                   =   null;
         File ifhfile                = DirectoryManager.getIfhFileForImage(imgfile);

         if (ifhfile == null || ifhfile.exists() == false){
            error               =   String.format(
                    "No image descriptor file\n"
                    + "is found for image %s\n"
                    + "Exiting...",  imgfile.getPath());

            DisplayText.popupErrorMessage(error);
            return false;
        }
        ImageDescriptor id  = ImageIO.loadFromDisk(ifhfile);
        if  (id.isLoaded() == false){
            error               =   String.format(
                    "Failed to load image descriptor file\n"
                    + "%s\n"
                    + "Exiting...",  ifhfile.getPath());

            DisplayText.popupErrorMessage(error);
            return false;

        }
        int nsclies         =   id.getNumberOfSlices();


        if (getEndSliceIndex() > nsclies){
             error               =   String.format(
                     "End slice number (%s) must be smaller\n"
                    + "than number of slices in the image (%s).\n"
                    + "Error is encountered while processing image\n"
                    + "%s.\n"
                    + "Exiting...", getEndSliceIndex() , nsclies, imgfile.getPath());

            DisplayText.popupErrorMessage(error);
            return false;
        }


        return true;

    }

    public static void createAndShowGUI() {

        //Create and set up the window.
        JFrame frame = new JFrame("Bayes Test Data ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {

            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                DirectoryManager.shutDownDirectory();
            }
        });

        frame.add(new BayesTestData());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGUI();
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buildModelButton;
    private javax.swing.JFormattedTextField endFormattedTextField;
    private javax.swing.JLabel endLabel;
    private javax.swing.JPanel graph_panel;
    private javax.swing.JPanel jPanel2;
    private interfacebeans.JResetSave jResetSave;
    private run.JRun jRun;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton jSystemModel;
    private javax.swing.JButton jUserModel;
    private interfacebeans.JServer jserver;
    private javax.swing.JPanel processSlice;
    private javax.swing.JButton savePriorsButton;
    private javax.swing.JFormattedTextField startFormatetedTextField;
    private javax.swing.JLabel startLabel;
    private javax.swing.JPanel tools;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    public javax.swing.JFormattedTextField getEndFormattedTextField () {
        return endFormattedTextField;
    }
    public javax.swing.JFormattedTextField getStartFormatetedTextField () {
        return startFormatetedTextField;
    }
    public javax.swing.JButton              getBuildModelButton() {
        return buildModelButton;
    }
    public javax.swing.JButton              getSavePriorsButton() {
        return savePriorsButton;
    }

    private String abscissa                            =   "Read";
    public String message                              =   "";
    private int endSliceIndex                          =   1;
    private int startSliceIndex                        =   1;
    private double maxAbacissaValue                    =   1.0;


    
    public String getAbscissa() {
        return abscissa;
    }
    public double getMaxAbacissaValue() {
        return maxAbacissaValue;
    }
     public String      getMessage      ( String aMessage ) { return message; }
     public EnterAsciiModel  getAsciiModel () {
        return JShowModels.getInstance().getSingleModel();
    }
  
     public String      getAsciiModelName(){ return  getAsciiModel().getName();}
     public int         getEndSliceIndex () {
        return endSliceIndex;
    }
     public int         getStartSliceIndex () {
        return startSliceIndex;
    }
 
   

     public void        setMessage      ( String aMessage ) {
        message =     aMessage;
        BayesView.setMenuBarMessage(message);
    }
 
     public void        setEndSliceIndex ( int anendSliceIndex ) {
         this.endSliceIndex             =   anendSliceIndex;
    }
     public void        setStartSliceIndex ( int astartSliceIndex ) {
        this.startSliceIndex        =   astartSliceIndex;
    }


    public void setAbscissa(String abscissa) {
        this.abscissa = abscissa;
    }

    public void setMaxAbacissaValue(double maxAbacissaValue) {
        this.maxAbacissaValue = maxAbacissaValue;
    }
  




  

  

  
     
    

   
}
