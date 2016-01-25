/**
 * Created by lukas on 1/25/16.
 */
package calc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Model {

    private String result = "";
    private String operator = "";
    private String operand = "";
    private String error = "";

    public String add(float a, float b) {
        try {
            RemoteCalc calc = (RemoteCalc) Naming.lookup("rmi://localhost:1099/Calculator");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return calc.add(a, b);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public String sub(float a, float b) {
        try {
            RemoteCalc calc = (RemoteCalc) Naming.lookup("rmi://localhost:1099/Calculator");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return calc.sub(a, b);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public String multi(float a, float b) {
        try {
            RemoteCalc calc = (RemoteCalc) Naming.lookup("rmi://localhost:1099/Calculator");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return calc.multi(a, b);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public String div(float a, float b) {
        try {
            RemoteCalc calc = (RemoteCalc) Naming.lookup("rmi://localhost:1099/Calculator");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return calc.div(a, b);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public void berechne() {
        try {
            // Resultat, Operator oder Operand liegen nicht vor => tue nichts
            if (this.result.equals("") || this.operator.equals("")
                    || this.operand.equals(""))
                return;
            // Ab hier normale Verarbeitung
            float a = Float.valueOf(this.result);
            float b = Float.valueOf(this.operand);

            if (this.operator.equals("+"))
//                this.result = String.valueOf(a + b);
                this.result = add(a, b);
            if (this.operator.equals("-"))
//                this.result = String.valueOf(a - b);
                this.result = sub(a, b);
            if (this.operator.equals("/")) {
                // Nicht durch Null teilen
                if (b == 0.0)
                    throw new Exception("Division by Zero");
//                this.result = String.valueOf(a / b);
                this.result = div(a, b);
            }
            if (this.operator.equals("*"))
//                this.result = String.valueOf(a * b);
                this.result = multi(a, b);
            this.operator = "";
            this.operand = "";
            this.error = "";
        } catch (Exception ex) {
            this.clear();
            this.error = ex.getMessage();
        }
    }

    public String getOperand() {

        return this.operand;
    }

    public String getResult() {

        return this.result;
    }

    public void setOperand(String op) {

        if (op.equals("") || op.equals(null))
            return;

        this.operand = op;

    }

    public String getOperator() {

        return this.operator;
    }

    public void setOperator(String op) {
        // Resultat, Operator und Operand existieren aus vorherigen Eingaben =>
        // erstmal
        // rechnen
        if (!(this.result.equals("") && this.operator.equals("") && this.operand
                .equals(""))) {
            this.berechne();
            if (!this.getError().equals("")) {
                return;
            }
            // Wenn Fehler aufgetreten, Methode verlassen
        }
        // Es wurde bereits ein Operand eingegeben => diesen zum Resultat machen
        if (!this.operand.equals("")) {
            this.result = this.operand;
            this.operand = "";
        }
        // Es liegt kein Resultat vor => Resultat auf Null setzen
        if (this.result.equals("")) {
            this.result = "0";
        }
        this.operator = op;
        this.error = "";
    }

    public String getError() {

        return this.error;

    }

    public void clear() {
        this.error = this.operand = this.operator = this.result = "";
    }

}
