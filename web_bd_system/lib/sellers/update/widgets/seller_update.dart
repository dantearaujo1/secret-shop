import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/sellers/update/api/sellers_update_model.dart';
import 'package:web_bd_system/sellers/update/bloc/sellers_update_bloc.dart';
import 'package:web_bd_system/sellers/update/bloc/sellers_update_event.dart';
import 'package:web_bd_system/sellers/update/bloc/sellers_update_state.dart';
import 'package:web_bd_system/utils/app_colors.dart';

class SellersUpdate extends StatelessWidget {
  SellersUpdate({super.key, required this.sellerID});

  final String sellerID;

  final TextEditingController _textFieldControllerName =
      TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Secret Beauty',
        ),
      ),
      body: BlocListener<SellersUpdateBloc, SellersUpdateState>(
        listener: (context, state) {
          switch (state.runtimeType) {
            case SellersUpdateSuccessState:
              Navigator.pop(context);
          }
        },
        child: Column(
          children: [
            const Padding(
              padding: EdgeInsets.all(24.0),
              child: Text(
                'Atualização de vendedor',
                style: TextStyle(fontSize: 20),
              ),
            ),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 24),
              child: TextField(
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Digite o o novo nome',
                ),
                controller: _textFieldControllerName,
              ),
            ),
            const SizedBox(
              height: 32,
            ),
            GestureDetector(
              onTap: () {
                final name = _textFieldControllerName.text;
                final model = SellersUpdateModel(sellerID, name);

                context
                    .read<SellersUpdateBloc>()
                    .add(SellersUpdateRequestEvent(model));
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
