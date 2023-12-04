import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/categories/home/api/categories_service.dart';
import 'package:web_bd_system/categories/home/bloc/categories_event.dart';
import 'package:web_bd_system/categories/home/bloc/categories_state.dart';

class CategoriesBloc extends Bloc<CategoriesEvent, CategoriesState> {
  CategoriesBloc(this.service) : super(CategoriesLoadingState()) {
    on<CategoriesRequestEvent>(_request);
    on<CategoriesRequestDeleteEvent>(_delete);
  }

  final CategoriesService service;

  void _request(
      CategoriesRequestEvent event, Emitter<CategoriesState> emit) async {
    emit(CategoriesLoadingState());
    try {
      final categoriess = await service.getCategories();
      emit(CategoriesSuccessState(categoriess));
    } catch (e) {
      emit(CategoriesErrorState());
    }
  }

  void _delete(
      CategoriesRequestDeleteEvent event, Emitter<CategoriesState> emit) async {
    try {
      await service.delete(event.id);
      emit(CategoriesDeletionSuccess());
    } catch (e) {
      emit(CategoriesDeletionError());
    }
  }
}
