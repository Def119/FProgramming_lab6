import scala.io.StdIn.readLine

@main def main()={
    // println(validate("asd",12,100))
    // println(validate("asd",12,1))
    // println(validate("",12,100))
    // if(validate("asd",12,100)){
    //     println("dpms")
    // }

    // println(gradeResults(10,100))
    // println(gradeResults(60,100))

    println(getStudentInfo())

}

def getStudentInfo():(String,Float,String) ={
    println("Enter your name: ")
    var name = readLine().trim
    println(s"Enter ${name}'s marks : ")
    var marks = readLine().toFloat
    println(s"Enter maximum possible marks : ")
    var max_marks = readLine().toFloat
        
        var valid = validate(name,marks,max_marks)

        if(valid){
            (name,marks,gradeResults(marks,max_marks))
        }else {
            // ("",12,"A")
            println("Information entered is invalid! try again.\n")
            getValidInfo()
        }
}
 
def getValidInfo():(String,Float,String)={
    var loop=true
    var name:String = ""
    var marks:Float = 0.0f
    var max_marks:Float =0.0f

       while (loop){
        println("Enter your name: ")
        name = readLine().trim
        println(s"Enter ${name}'s marks : ")
        marks = readLine().toFloat
        println(s"Enter maximum possible marks : ")
        max_marks = readLine().toFloat

        if(validate(name,marks,max_marks)){
           loop=false
        }else{
            println("invalid data, please try again.\n")
        }
       }
        return (name,marks,gradeResults(marks,max_marks))
}

def validate(name:String, marks:Float, max:Float): Boolean={
    if(name.isEmpty){
        return false
    }else if(marks < 0){
        return false
    }else if (max < 0 || max < marks){
        return false
    }else {
        true
    }
}

def gradeResults(marks:Float,max:Float):String={
    var perc = marks*100/max

    perc match {
        case x if x >= 90 => "A"
        case x if x >=75 => "B"
        case x if x >= 50 => "C"
        case _ => "D"
    }
}