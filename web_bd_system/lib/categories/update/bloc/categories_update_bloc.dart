import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/categories/update/api/categories_update_service.dart';
import 'package:web_bd_system/categories/update/bloc/categories_update_event.dart';
import 'package:web_bd_system/categories/update/bloc/categories_update_state.dart';

class CategoriesUpdateBloc
    extends Bloc<CategoriesUpdateEvent, CategoriesUpdateState> {
  CategoriesUpdateBloc(this.service) : super(CategoriesUpdateLoadingState()) {
    on<CategoriesUpdateRequestEvent>(_request);
  }

  final CategoriesUpdateService service;

  void _request(CategoriesUpdateRequestEvent event,
      Emitter<CategoriesUpdateState> emit) async {
    try {
      final _ = await service.update(event.model);
      emit(CategoriesUpdateSuccessState());
    } catch (e) {
      emit(CategoriesUpdateErrorState());
    }
  }
}
