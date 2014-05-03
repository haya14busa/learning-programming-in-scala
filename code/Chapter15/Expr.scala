sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(name: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String,
                left: Expr,
                right: Expr) extends Expr
