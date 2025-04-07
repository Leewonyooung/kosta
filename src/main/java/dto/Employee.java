package dto;

public class Employee {
    String emp_no;
    String pw;
    String emp_nm;

    public Employee() {
    }

    public Employee(String emp_no, String pw, String emp_nm) {
        this.emp_no = emp_no;
        this.pw = pw;
        this.emp_nm = emp_nm;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmp_nm() {
        return emp_nm;
    }

    public void setEmp_nm(String emp_nm) {
        this.emp_nm = emp_nm;
    }
}
