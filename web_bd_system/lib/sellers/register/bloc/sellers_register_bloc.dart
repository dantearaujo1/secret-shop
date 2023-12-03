import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/sellers/register/api/sellers_register_service.dart';
import 'package:web_bd_system/sellers/register/bloc/sellers_register_event.dart';
import 'package:web_bd_system/sellers/register/bloc/sellers_register_state.dart';

class SellersRegisterBloc
    extends Bloc<SellersRegisterEvent, SellersRegisterState> {
  SellersRegisterBloc(this.service) : super(SellersRegisterLoadingState()) {
    on<SellersRegisterRequestEvent>(_request);
  }

  final SellersRegisterService service;

  void _request(SellersRegisterRequestEvent event,
      Emitter<SellersRegisterState> emit) async {
    try {
      final _ = await service.createSellers(event.model);
      emit(SellersRegisterSuccessState());
    } catch (e) {
      emit(SellersRegisterErrorState());
    }
  }
}