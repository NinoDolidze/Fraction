fun main(){
        val variables = Point ("1" , "2")
        println(variables.X)
        println(variables.Y)
        val x = 1
        val y = 2
        println(x == y)
        val f1 = Fraction()
        f1.numerator = 3.0
        f1.denominator = 4.0

        val f2 = Fraction()
        f2.numerator = 3.0
        f2.denominator = 4.0

        val f3 = Fraction()
        f3.numerator =  0.0
        f3.denominator= 0.0

        println(f1 == f2)
        println(f1.toString())
        val sum = Fraction(3.0, 4.0) + Fraction(3.0, 4.0)
        println("ჯამი: ${sum.decimal}")

//        var multiplication = (f1.numerator*f2.numerator) + (f1.denominator*f2.denominator)
//        println("ნამრავლი: ${f1.numerator*f2.numerator / f1.denominator*f2.denominator}")
        }


class Point (var X: String, var Y: String)
{
    override fun toString(): String {
        return "$X\$Y"
    }

}

class Fraction (var numerator:Double = 0.0, var denominator:Double = 0.0 ) : Comparable<Fraction>{

    override fun equals (other: Any?): Boolean {
        if (other is Fraction){
            if(numerator*other.denominator / denominator == other.numerator){
                return true

            }
        }
        return false
    }

    override fun toString(): String {
        return "$numerator, $denominator"
    }
    operator fun plus(add: Fraction) =
        if (this.denominator == add.denominator){
            Fraction(this.numerator + add.numerator, denominator)
        } else {
            val a = this * add.denominator
            val b = add * this.denominator
            Fraction(a.numerator + b.numerator, a.denominator)
        }
    operator fun times(num: Double) = Fraction(numerator * num, denominator * num)
    override fun compareTo(other: Fraction) = denominator.compareTo(other.denominator)
    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        return result
    }

    val decimal by lazy { numerator / denominator }



    }



