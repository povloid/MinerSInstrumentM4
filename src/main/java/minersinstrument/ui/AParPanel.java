/*
 * AParPanel.java
 *
 * Created on 16 Февраль 2008 г., 11:52
 */
package minersinstrument.ui;

import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author  PKopychenko
 */
public class AParPanel extends javax.swing.JPanel {

    private ModelForParams modelForParams = new ModelForParams();

    /** Creates new form AParPanel */
    public AParPanel() {
        initComponents();


        parTable.getColumnModel().getColumn(0).setMinWidth(100);
        parTable.getColumnModel().getColumn(0).setMaxWidth(200);
        parTable.getColumnModel().getColumn(0).setWidth(150);
        //parTable.setAlignmentX(10.0F);
        //parTable.setAlignmentY(1.0F);
        parTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void addParRow(String s, Object o) {
        modelForParams.addRow(s, o);
    }

    public void clear() {
        modelForParams.clear();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        parTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setEnabled(false);

        parTable.setModel(modelForParams);
        parTable.setAutoscrolls(false);
        parTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(parTable);
        parTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setText("Параметры");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE).addComponent(jLabel1)).addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE).addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable parTable;
    // End of variables declaration//GEN-END:variables
}

class PElement {

    public String p;
    public Object o;

    public PElement() {
        p = "Параметр";
        o = new String("Значение");
    }

    public PElement(String p, Object o) {
        this.p = p;

        Class oClass = o.getClass();

        //Type t = o.getClass().getComponentType();

        if (oClass == Boolean.class) {
            Boolean b = (Boolean) o;
            if (b) {
                this.o = "Да";
            } else {
                this.o = "Нет";
            }
        } else {
            this.o = o.toString();
        }
    }
}

class ColumnData {

    public String m_title;
    int m_width;
    int m_alignment;

    public ColumnData(String title, int width, int alignment) {
        m_title = title;
        m_width = width;
        m_alignment = alignment;
    }
}

class ModelForParams extends AbstractTableModel {

    public static final ColumnData m_columns[] = {
        new ColumnData("Параметр", 80, JLabel.CENTER),
        new ColumnData("Значение", 80, JLabel.CENTER)
    };
    public static final int COL_PARAMTR_NAME = 0;
    public static final int COL_VALUE = 1;
    protected Vector m_vector;

    public ModelForParams() {
        m_vector = new Vector();
    }

    public void setDefaultData() {
        m_vector.removeAllElements();

        m_vector.addElement(new PElement());
        m_vector.addElement(new PElement());
        m_vector.addElement(new PElement());
    }

    public void clear() {
        m_vector.removeAllElements();
    }

    public int getRowCount() {
        return m_vector == null ? 0 : m_vector.size();
    }

    public int getColumnCount() {
        return m_columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return m_columns[column].m_title;
    }

    public Object getValueAt(int nRow, int nCol) {
        if (nRow < 0 || nRow >= getRowCount()) {
            return "";
        }
        PElement row = (PElement) m_vector.elementAt(nRow);
        switch (nCol) {
            case COL_PARAMTR_NAME:
                return row.p;
            case COL_VALUE:
                return row.o;
        }
        return "";

    }

    public void addRow(String p, Object o) {
        m_vector.addElement(new PElement(p, o));
    }
}

