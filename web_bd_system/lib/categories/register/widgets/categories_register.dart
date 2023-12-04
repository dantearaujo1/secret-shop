import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/categories/register/api/categories_post_model.dart';
import 'package:web_bd_system/categories/register/bloc/categories_register_bloc.dart';
import 'package:web_bd_system/categories/register/bloc/categories_register_event.dart';
import 'package:web_bd_system/categories/register/bloc/categories_register_state.dart';
import 'package:web_bd_system/utils/app_colors.dart';

class CategoriesRegister extends StatelessWidget {
  CategoriesRegister({super.key});

  final TextEditingController _textFieldControllerName =
      TextEditingController();
  final TextEditingController _textFieldControllerDescription =
      TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Secret Beauty',
        ),
      ),
      body: BlocListener<CategoriesRegisterBloc, CategoriesRegisterState>(
        listener: (context, state) {
          switch (state.runtimeType) {
            case CategoriesRegisterSuccessState:
              Navigator.pop(context);
          }
        },
        child: Column(
          children: [
            const Padding(
              padding: EdgeInsets.all(24.0),
              child: Text('Cadastro de Categorias',
                  style: TextStyle(fontSize: 20)),
            ),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 24),
              child: TextField(
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Digite o nome da categoria',
                ),
                controller: _textFieldControllerName,
              ),
            ),
            const SizedBox(
              height: 24,
            ),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 24),
              child: TextField(
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Digite a descrição',
                ),
                controller: _textFieldControllerDescription,
              ),
            ),
            const SizedBox(
              height: 32,
            ),
            GestureDetector(
              onTap: () {
                final name = _textFieldControllerName.text;
                final description = _textFieldControllerDescription.text;
                final model = CategoriesPostModel(name, description);

                context
                    .read<CategoriesRegisterBloc>()
                    .add(CategoriesRegisterRequestEvent(model));
              },
              child: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 24.0),
                child: Container(
                  width: double.infinity,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(8),
                    color: AppColors.primaryColor,
                  ),
                  child: const Padding(
                    padding: EdgeInsets.all(20.0),
                    child: Text(
                      'Cadastrar',
                      textAlign: TextAlign.center,
                      style:
                          TextStyle(fontSize: 20, fontWeight: FontWeight.w500),
                    ),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
