import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/sellers/update/api/sellers_update_service.dart';
import 'package:web_bd_system/sellers/update/bloc/sellers_update_event.dart';
import 'package:web_bd_system/sellers/update/bloc/sellers_update_state.dart';

class SellersUpdateBloc
    extends Bloc<SellersUpdateEvent, SellersUpdateState> {
  SellersUpdateBloc(this.service) : super(SellersUpdateLoadingState()) {
    on<SellersUpdateRequestEvent>(_request);
  }

  final SellersUpdateService service;

  void _request(SellersUpdateRequestEvent event,
      Emitter<SellersUpdateState> emit) async {
    try {
      final _ = await service.update(event.model);
      emit(SellersUpdateSuccessState());
    } catch (e) {
      emit(SellersUpdateErrorState());
    }
  }
}
