import 'package:equatable/equatable.dart';

abstract class SellersEvent extends Equatable {
  const SellersEvent();

  @override
  List<Object?> get props => [];
}

final class SellersRequestEvent extends SellersEvent {}

final class SellersRequestDeleteEvent extends SellersEvent {
  final String id;

  const SellersRequestDeleteEvent(this.id);

  @override
  List<Object?> get props => [id];
}