package evaluator;

import ExprTree.*;

/**
 * Created by lukas on 4/15/16.
 */
public interface Evaluator {

    double eval(Add a);
    double eval(Sub S);
    double eval(UMinus u);
//    double eval(Mul m);
//    double eval(Div d);
//    double eval(Pow p);
    double eval(Int i);
}
