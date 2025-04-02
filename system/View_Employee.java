
package employee.management.system;

//import net.proteanit.sql.DbUtils;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class View_Employee extends JFrame    implements ActionListener {

    JTable table;
    Choice choiceEMP;
    JButton searchbtn, print, update, back;
    <conn> View_Employee(){

        getContentPane().setBackground(new Color(255,131,122));
        JLabel search = new JLabel("Search by employee id");
        search.setBounds(20,20,150,20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180,20,150,20);
        add(choiceEMP);

        try{
            Connection c = new Connection() {
                @Override
                public Statement createStatement() throws SQLException
                {
                    return null;
                }

                @Override
                public PreparedStatement prepareStatement(String sql) throws SQLException {
                    return null;
                }

                @Override
                public CallableStatement prepareCall(String sql) throws SQLException {
                    return null;
                }

                @Override
                public String nativeSQL(String sql) throws SQLException {
                    return null;
                }

                @Override
                public void setAutoCommit(boolean autoCommit) throws SQLException {

                }

                @Override
                public boolean getAutoCommit() throws SQLException {
                    return false;
                }

                @Override
                public void commit() throws SQLException {

                }

                @Override
                public void rollback() throws SQLException {

                }

                @Override
                public void close() throws SQLException {

                }

                @Override
                public boolean isClosed() throws SQLException {
                    return false;
                }

                @Override
                public DatabaseMetaData getMetaData() throws SQLException {
                    return null;
                }

                @Override
                public void setReadOnly(boolean readOnly) throws SQLException {

                }

                @Override
                public boolean isReadOnly() throws SQLException {
                    return false;
                }

                @Override
                public void setCatalog(String catalog) throws SQLException {

                }

                @Override
                public String getCatalog() throws SQLException {
                    return null;
                }

                @Override
                public void setTransactionIsolation(int level) throws SQLException {

                }

                @Override
                public int getTransactionIsolation() throws SQLException {
                    return 0;
                }

                @Override
                public SQLWarning getWarnings() throws SQLException {
                    return null;
                }

                @Override
                public void clearWarnings() throws SQLException {

                }

                @Override
                public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
                    return null;
                }

                @Override
                public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
                    return null;
                }

                @Override
                public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
                    return null;
                }

                @Override
                public Map<String, Class<?>> getTypeMap() throws SQLException {
                    return null;
                }

                @Override
                public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

                }

                @Override
                public void setHoldability(int holdability) throws SQLException {

                }

                @Override
                public int getHoldability() throws SQLException {
                    return 0;
                }

                @Override
                public Savepoint setSavepoint() throws SQLException {
                    return null;
                }

                @Override
                public Savepoint setSavepoint(String name) throws SQLException {
                    return null;
                }

                @Override
                public void rollback(Savepoint savepoint) throws SQLException {

                }

                @Override
                public void releaseSavepoint(Savepoint savepoint) throws SQLException {

                }

                @Override
                public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
                    return null;
                }

                @Override
                public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
                    return null;
                }

                @Override
                public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
                    return null;
                }

                @Override
                public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
                    return null;
                }

                @Override
                public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
                    return null;
                }

                @Override
                public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
                    return null;
                }

                @Override
                public Clob createClob() throws SQLException {
                    return null;
                }

                @Override
                public Blob createBlob() throws SQLException {
                    return null;
                }

                @Override
                public NClob createNClob() throws SQLException {
                    return null;
                }

                @Override
                public SQLXML createSQLXML() throws SQLException {
                    return null;
                }

                @Override
                public boolean isValid(int timeout) throws SQLException {
                    return false;
                }

                @Override
                public void setClientInfo(String name, String value) throws SQLClientInfoException {

                }

                @Override
                public void setClientInfo(Properties properties) throws SQLClientInfoException {

                }

                @Override
                public String getClientInfo(String name) throws SQLException {
                    return null;
                }

                @Override
                public Properties getClientInfo() throws SQLException {
                    return null;
                }

                @Override
                public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
                    return null;
                }

                @Override
                public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
                    return null;
                }

                @Override
                public void setSchema(String schema) throws SQLException {

                }

                @Override
                public String getSchema() throws SQLException {
                    return null;
                }

                @Override
                public void abort(Executor executor) throws SQLException {

                }

                @Override
                public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

                }

                @Override
                public int getNetworkTimeout() throws SQLException {
                    return 0;
                }

                @Override
                public <T> T unwrap(Class<T> iface) throws SQLException {
                    return null;
                }

                @Override
                public boolean isWrapperFor(Class<?> iface) throws SQLException {
                    return false;
                }
            };
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceEMP.add(resultSet.getString("empId"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            conn c= new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,900,600);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(20,70,80,20);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);


        setSize(900,700);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn){
            String query = "select * from employee where empId = '"+choiceEMP.getSelectedItem()+"'";
            try {
                Connection c = new Connection() {
                    @Override
                    public Statement createStatement() throws SQLException {
                        return null;
                    }

                    @Override
                    public PreparedStatement prepareStatement(String sql) throws SQLException {
                        return null;
                    }

                    @Override
                    public CallableStatement prepareCall(String sql) throws SQLException {
                        return null;
                    }

                    @Override
                    public String nativeSQL(String sql) throws SQLException {
                        return null;
                    }

                    @Override
                    public void setAutoCommit(boolean autoCommit) throws SQLException {

                    }

                    @Override
                    public boolean getAutoCommit() throws SQLException {
                        return false;
                    }

                    @Override
                    public void commit() throws SQLException {

                    }

                    @Override
                    public void rollback() throws SQLException {

                    }

                    @Override
                    public void close() throws SQLException {

                    }

                    @Override
                    public boolean isClosed() throws SQLException {
                        return false;
                    }

                    @Override
                    public DatabaseMetaData getMetaData() throws SQLException {
                        return null;
                    }

                    @Override
                    public void setReadOnly(boolean readOnly) throws SQLException {

                    }

                    @Override
                    public boolean isReadOnly() throws SQLException {
                        return false;
                    }

                    @Override
                    public void setCatalog(String catalog) throws SQLException {

                    }

                    @Override
                    public String getCatalog() throws SQLException {
                        return null;
                    }

                    @Override
                    public void setTransactionIsolation(int level) throws SQLException {

                    }

                    @Override
                    public int getTransactionIsolation() throws SQLException {
                        return 0;
                    }

                    @Override
                    public SQLWarning getWarnings() throws SQLException {
                        return null;
                    }

                    @Override
                    public void clearWarnings() throws SQLException {

                    }

                    @Override
                    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
                        return null;
                    }

                    @Override
                    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
                        return null;
                    }

                    @Override
                    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
                        return null;
                    }

                    @Override
                    public Map<String, Class<?>> getTypeMap() throws SQLException {
                        return null;
                    }

                    @Override
                    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {

                    }

                    @Override
                    public void setHoldability(int holdability) throws SQLException {

                    }

                    @Override
                    public int getHoldability() throws SQLException {
                        return 0;
                    }

                    @Override
                    public Savepoint setSavepoint() throws SQLException {
                        return null;
                    }

                    @Override
                    public Savepoint setSavepoint(String name) throws SQLException {
                        return null;
                    }

                    @Override
                    public void rollback(Savepoint savepoint) throws SQLException {

                    }

                    @Override
                    public void releaseSavepoint(Savepoint savepoint) throws SQLException {

                    }

                    @Override
                    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
                        return null;
                    }

                    @Override
                    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
                        return null;
                    }

                    @Override
                    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
                        return null;
                    }

                    @Override
                    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
                        return null;
                    }

                    @Override
                    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
                        return null;
                    }

                    @Override
                    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
                        return null;
                    }

                    @Override
                    public Clob createClob() throws SQLException {
                        return null;
                    }

                    @Override
                    public Blob createBlob() throws SQLException {
                        return null;
                    }

                    @Override
                    public NClob createNClob() throws SQLException {
                        return null;
                    }

                    @Override
                    public SQLXML createSQLXML() throws SQLException {
                        return null;
                    }

                    @Override
                    public boolean isValid(int timeout) throws SQLException {
                        return false;
                    }

                    @Override
                    public void setClientInfo(String name, String value) throws SQLClientInfoException {

                    }

                    @Override
                    public void setClientInfo(Properties properties) throws SQLClientInfoException {

                    }

                    @Override
                    public String getClientInfo(String name) throws SQLException {
                        return null;
                    }

                    @Override
                    public Properties getClientInfo() throws SQLException {
                        return null;
                    }

                    @Override
                    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
                        return null;
                    }

                    @Override
                    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
                        return null;
                    }

                    @Override
                    public void setSchema(String schema) throws SQLException {

                    }

                    @Override
                    public String getSchema() throws SQLException {
                        return null;
                    }

                    @Override
                    public void abort(Executor executor) throws SQLException {

                    }

                    @Override
                    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {

                    }

                    @Override
                    public int getNetworkTimeout() throws SQLException {
                        return 0;
                    }

                    @Override
                    public <T> T unwrap(Class<T> iface) throws SQLException {
                        return null;
                    }

                    @Override
                    public boolean isWrapperFor(Class<?> iface) throws SQLException {
                        return false;
                    }
                };
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == print)
        {
            try {
                table.print();
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == update){
            setVisible(false);
            new UpdateEmployee(choiceEMP.getSelectedItem());
        } else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {

        new View_Employee();
    }
}