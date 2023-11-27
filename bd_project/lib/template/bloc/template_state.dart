import 'package:equatable/equatable.dart';

abstract class TemplateState extends Equatable {
  const TemplateState();

  @override
  List<Object?> get props => [];
}

final class TemplateLoadingState extends TemplateState {}

final class TemplateErrorState extends TemplateState {}

final class TemplateSuccessState extends TemplateState {
  final String quote;

  const TemplateSuccessState(this.quote);

  @override
  List<Object?> get props => [quote];
}
