package calc;

public class Model {

	private String result = "";
	private String operator = "";
	private String operand = "";
	private String error = "";
	
		
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
				this.result = String.valueOf(a + b);
			if (this.operator.equals("-"))
				this.result = String.valueOf(a - b);
			if (this.operator.equals("/")) {
				// Nicht durch Null teilen
				if (b == 0.0)
					throw new Exception("Division by Zero");
				this.result = String.valueOf(a / b);
			}
			if (this.operator.equals("*"))
				this.result = String.valueOf(a * b);
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
