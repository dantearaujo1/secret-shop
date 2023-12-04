import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/categories/update/api/categories_update_model.dart';
import 'package:web_bd_system/categories/update/bloc/categories_update_bloc.dart';
import 'package:web_bd_system/categories/update/bloc/categories_update_event.dart';
import 'package:web_bd_system/categories/update/bloc/categories_update_state.dart';
import 'package:web_bd_system/utils/app_colors.dart';

class CategoriesUpdate extends StatelessWidget {
  CategoriesUpdate({super.key, required this.categoryID});

  final String categoryID;

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
      body: BlocListener<CategoriesUpdateBloc, CategoriesUpdateState>(
        listener: (context, state) {
          switch (state.runtimeType) {
            case CategoriesUpdateSuccessState:
              Navigator.pop(context);
          }
        },
        child: Column(
          children: [
            const Padding(
              padding: EdgeInsets.all(24.0),
              child: Text(
                'Atualização de categorias',
                style: TextStyle(fontSize: 20),
              ),
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
                final model =
                    CategoriesUpdateModel(categoryID, name, description);

                context
                    .read<CategoriesUpdateBloc>()
                    .add(CategoriesUpdateRequestEvent(model));
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
                      'Atualizar',
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        fontSize: 20,
                        fontWeight: FontWeight.w500,
                      ),
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
