
import scala.collection.mutable
case class Product(pid:String ,name:String ,quantity:Int ,unitprice: Int)

@main def main() ={
   val products = Map("001"-> Product("001","Milk",20,400),"002"->Product("002","chocolate",100,110))
   val inventory2 = Map("003"->Product("003","Samaposha",15,90),"002"->Product("002","chocolate",20,130))
  
   println(retrieveProducts(products)) 

   println(" \n total value : "+ totalValue(products)) 

   println("Inventory1 empty :" + checkEmpty(products))

//check for a product using the product id:
   checkProduct(products,"002");

   val newMap = mergeMaps(products,inventory2);
   println(newMap);
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




def mergeMaps(products1: Map[String, Product], products2: Map[String, Product]): Map[String, Product] = {
  
  val mergemap: mutable.Map[String, Product] = mutable.Map()

  // Update with duplicate products
  for ((pid, product) <- products1) {
    if (products2.contains(pid)) {
      val product2 = products2(pid)
      val updatedProduct = product.copy(
        quantity = product.quantity + product2.quantity,
        unitprice = math.max(product.unitprice, product2.unitprice)
      )
      mergemap(pid) = updatedProduct
    } else {
      mergemap(pid) = product
    }
  }

  // Add non repeating products
  for ((pid, product) <- products2) {
    if (!mergemap.contains(pid)) {
      mergemap(pid) = product
    }
  }

  // Convert the mutable map to an immutable map otherewise gives a return type error
  mergemap.toMap
}

