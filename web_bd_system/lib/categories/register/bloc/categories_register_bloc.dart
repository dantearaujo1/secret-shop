import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/categories/register/api/categories_register_service.dart';
import 'package:web_bd_system/categories/register/bloc/categories_register_event.dart';
import 'package:web_bd_system/categories/register/bloc/categories_register_state.dart';

class CategoriesRegisterBloc
    extends Bloc<CategoriesRegisterEvent, CategoriesRegisterState> {
  CategoriesRegisterBloc(this.service) : super(CategoriesRegisterLoadingState()) {
    on<CategoriesRegisterRequestEvent>(_request);
  }

  final CategoriesRegisterService service;

  void _request(CategoriesRegisterRequestEvent event,
      Emitter<CategoriesRegisterState> emit) async {
    try {
      final _ = await service.createCategories(event.model);
      emit(CategoriesRegisterSuccessState());
    } catch (e) {
      emit(CategoriesRegisterErrorState());
    }
  }
}
