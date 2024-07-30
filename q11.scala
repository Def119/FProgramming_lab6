case class Product(pid:String ,name:String ,quantity:Int ,unitprice: Int)

@main def main() ={
   val products = Map("001"-> Product("001","Milk",20,400),"002"->Product("002","chocolate",100,110))
   val inventory2 = Map("003"->Product("003","Samaposha",15,90),"002"->Product("002","chocolate",20,110))
  
   println(retrieveProducts(products)) 

   println(" \n total value : "+ totalValue(products)) 

   println("Inventory1 empty :" + checkEmpty(products))

//check for a product using the product id:
   checkProduct(products,"002");
}

def retrieveProducts(products : Map[String,Product]): List[String]={
    // products.values.name.toList;  //values here are not iterable
    products.values.map(_.name).toList
}

def totalValue(products : Map[String,Product]): Float={
    products.values.map(x => x.unitprice*x.quantity).sum
}

def checkEmpty(products: Map[String,Product]):Boolean ={
    products.isEmpty
}

// def mergeMaps(products1:Map[String,Product],products2:Map[String,Product]):Map[String,Product] ={
//     products1.keys.map(product=> products2.contains(product))
// } 


def checkProduct(products:Map[String,Product],key: String):Unit={
    var exist = products.contains(key)
    if (exist==true){
        println(products(key))
    }else{
        println("Inquired product does not exist\n")
    }
}