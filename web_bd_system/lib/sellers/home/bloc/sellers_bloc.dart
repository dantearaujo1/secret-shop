
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/sellers/home/api/sellers_service.dart';
import 'package:web_bd_system/sellers/home/bloc/sellers_event.dart';
import 'package:web_bd_system/sellers/home/bloc/sellers_state.dart';

class SellersBloc extends Bloc<SellersEvent, SellersState> {
  SellersBloc(this.service) : super(SellersLoadingState()) {
    on<SellersRequestEvent>(_request);
    on<SellersRequestDeleteEvent>(_delete);
  }

  final SellersService service;

  void _request(SellersRequestEvent event, Emitter<SellersState> emit) async {
    emit(SellersLoadingState());
    try {
      final sellers = await service.getSellerss();
      emit(SellersSuccessState(sellers));
    } catch (e) {
      emit(SellersErrorState());
    }
  }

  void _delete(
      SellersRequestDeleteEvent event, Emitter<SellersState> emit) async {
    try {
      await service.delete(event.id);
      emit(SellersDeletionSuccess());
    } catch (e) {
      emit(SellersDeletionError());
    }
  }
}