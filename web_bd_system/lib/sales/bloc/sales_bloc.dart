import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/sales/api/sales_service.dart';
import 'package:web_bd_system/sales/bloc/sales_event.dart';
import 'package:web_bd_system/sales/bloc/sales_state.dart';

class SalesBloc extends Bloc<SalesEvent, SalesState> {
  SalesBloc(this.service) : super(SalesLoadingState()) {
    on<SalesRequestEvent>(_request);
  }

  final SalesService service;

  void _request(
      SalesRequestEvent event, Emitter<SalesState> emit) async {
    emit(SalesLoadingState());
    try {
      final sales = await service.getSales();
      emit(SalesSuccessState(sales));
    } catch (e) {
      emit(SalesErrorState());
    }
  }
}