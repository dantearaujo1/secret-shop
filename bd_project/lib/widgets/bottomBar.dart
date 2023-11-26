import 'package:bd_project/pages/client_page.dart';
import 'package:bd_project/pages/branch_page.dart';
import 'package:bd_project/pages/sell_page.dart';
import 'package:bd_project/pages/seller_page.dart';
import 'package:bd_project/pages/search_page.dart';
import 'package:bd_project/pages/category_page.dart';
import 'package:bd_project/pages/product_page.dart';
import 'package:flutter/material.dart';

class BottomBar extends StatelessWidget {
  const BottomBar({super.key});

  @override
  Widget build(BuildContext context) {
    return ButtonBar(
            children:[
            IconButton(
              icon:const Image(
                image:AssetImage("assets/people.png")
              ),
              onPressed: (){
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => ClientPage()),
                );
              }),
            IconButton(
              icon:const Image(
                image:AssetImage("assets/seller.png")
              ),
              onPressed: (){
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => SellerPage()),
                );
              }
            ),
            IconButton(
              icon:const Image(image:AssetImage("assets/group.png")),
              onPressed: (){
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => CategoryPage()),
                );
              }
            ),
            IconButton(
              icon:const Image(image:AssetImage("assets/filial.png")),
              onPressed: (){
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => BranchPage()),
                );
              }
            ),
            IconButton(
              icon:const Image(image:AssetImage("assets/product.png")),
              onPressed: (){
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => ProductPage()),
                );
              }
            ),
            IconButton(
              icon:const Image(image:AssetImage("assets/sell.png")),
              onPressed: (){
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => SellPage()),
                );
              }
            ),
            IconButton(
              icon:const Image(image:AssetImage("assets/procurar.png")),
              onPressed: (){
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => SearchPage()),
                );
              }
            ),
            ]
          );
  }
}
