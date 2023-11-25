import 'package:bd_project/template/api/template_service.dart';
import 'package:bd_project/template/bloc/template_event.dart';
import 'package:bd_project/template/bloc/template_state.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

class TemplateBloc extends Bloc<TemplateEvent, TemplateState> {
  TemplateBloc(this.service) : super(TemplateLoadingState()) {
    on<TemplateRequestEvent>(_request);
  }

  final TemplateService service;

  void _request(TemplateRequestEvent event, Emitter<TemplateState> emit) async {
    try {
      final quote = await service.getQuote();
      emit(TemplateSuccessState(quote));
    } catch (_) {
      emit(TemplateErrorState());
    }
  }
}
