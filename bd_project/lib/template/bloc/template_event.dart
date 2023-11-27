import 'package:equatable/equatable.dart';

abstract class TemplateEvent extends Equatable {
  const TemplateEvent();

  @override
  List<Object?> get props => [];
}

final class TemplateRequestEvent extends TemplateEvent {}