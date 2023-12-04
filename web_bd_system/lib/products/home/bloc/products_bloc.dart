import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/products/home/api/products_service.dart';
import 'package:web_bd_system/products/home/bloc/products_event.dart';
import 'package:web_bd_system/products/home/bloc/produts_state.dart';

class ProductsBloc extends Bloc<ProductsEvent, ProductsState> {
  ProductsBloc(this.service) : super(ProductsLoadingState()) {
    on<ProductsRequestEvent>(_request);
    on<ProductsRequestDeleteEvent>(_delete);
  }

  final ProductsService service;

  void _request(ProductsRequestEvent event, Emitter<ProductsState> emit) async {
    emit(ProductsLoadingState());
    try {
      final products = await service.getProducts();
      emit(ProductsSuccessState(products));
    } catch (e) {
      emit(ProductsErrorState());
    }
  }

  void _delete(
      ProductsRequestDeleteEvent event, Emitter<ProductsState> emit) async {
    try {
      await service.delete(event.id);
      emit(ProductsDeletionSuccess());
    } catch (e) {
      emit(ProductsDeletionError());
    }
  }
}
