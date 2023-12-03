import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/categories/home/widgets/categories.dart';
import 'package:web_bd_system/categories/register/api/categories_register_service.dart';
import 'package:web_bd_system/categories/register/bloc/categories_register_bloc.dart';
import 'package:web_bd_system/categories/register/widgets/categories_register.dart';
import 'package:web_bd_system/clients/register/api/client_register_service.dart';
import 'package:web_bd_system/clients/register/bloc/client_register_bloc.dart';
import 'package:web_bd_system/clients/register/client_register.dart';
import 'package:web_bd_system/clients/home/widgets/clients.dart';
import 'package:web_bd_system/products/home/widgets/products.dart';
import 'package:web_bd_system/sales/widgets/sales.dart';
import 'package:web_bd_system/sellers/home/widgets/sellers.dart';
import 'package:web_bd_system/sellers/register/api/sellers_register_service.dart';
import 'package:web_bd_system/sellers/register/bloc/sellers_register_bloc.dart';
import 'package:web_bd_system/sellers/register/sellers_register.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _selectedIndex = 0;

  static const List<Widget> _widgetOptions = <Widget>[
    Sellers(),
    Clients(),
    Products(),
    Categories(),
    Sales(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  String _setTitleBasedIndex() {
    switch (_selectedIndex) {
      case 0:
        return 'Vendedores';
      case 1:
        return 'Clientes';
      case 2:
        return 'Produtos';
      case 3:
        return 'Categorias';
      case 4:
        return 'Vendas';
      default:
        return 'Secret Beauty';
    }
  }

  void _onPressedRegisterButton(BuildContext context) {
    switch (_selectedIndex) {
      case 0:
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (_) => BlocProvider(
              create: (_) => SellersRegisterBloc(
                SellersRegisterServiceImpl(),
              ),
              child: SellersRegister(),
            ),
          ),
        );
      case 1:
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (_) => BlocProvider(
              create: (_) => ClientRegisterBloc(
                ClientRegisterServiceImpl(),
              ),
              child: ClientRegister(),
            ),
          ),
        );
      case 3:
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (_) => BlocProvider(
              create: (_) => CategoriesRegisterBloc(
                CategoriesRegisterServiceImpl(),
              ),
              child: CategoriesRegister(),
            ),
          ),
        );
      default:
        print('Cenário inválido');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(_setTitleBasedIndex()),
        actions: _selectedIndex == 4
            ? []
            : [
                IconButton(
                  icon: const Padding(
                    padding: EdgeInsets.all(8.0),
                    child: Icon(
                      Icons.add,
                      size: 32,
                    ),
                  ),
                  onPressed: () {
                    _onPressedRegisterButton(context);
                  },
                )
              ],
      ),
      // floatingActionButton: ,
      body: Center(
        child: _widgetOptions[_selectedIndex],
      ),
      drawer: Drawer(
        child: ListView(
          padding: EdgeInsets.zero,
          children: [
            const DrawerHeader(
              decoration: BoxDecoration(
                color: Colors.black12,
              ),
              child: Text(
                'Secret Beauty',
                style: TextStyle(fontWeight: FontWeight.bold, fontSize: 32),
              ),
            ),
            ListTile(
              title: const Text('Vendedores'),
              selected: _selectedIndex == 0,
              onTap: () {
                _onItemTapped(0);
                Navigator.pop(context);
              },
            ),
            ListTile(
              title: const Text('Clientes'),
              selected: _selectedIndex == 1,
              onTap: () {
                _onItemTapped(1);
                Navigator.pop(context);
              },
            ),
            ListTile(
              title: const Text('Produtos'),
              selected: _selectedIndex == 2,
              onTap: () {
                _onItemTapped(2);
                Navigator.pop(context);
              },
            ),
            ListTile(
              title: const Text('Categorias'),
              selected: _selectedIndex == 3,
              onTap: () {
                _onItemTapped(3);
                Navigator.pop(context);
              },
            ),
            ListTile(
              title: const Text('Vendas'),
              selected: _selectedIndex == 4,
              onTap: () {
                _onItemTapped(4);
                Navigator.pop(context);
              },
            ),
          ],
        ),
      ),
    );
  }
}
