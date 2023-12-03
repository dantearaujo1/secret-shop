import 'package:equatable/equatable.dart';
import 'package:web_bd_system/sellers/update/api/sellers_update_model.dart';

abstract class SellersUpdateEvent extends Equatable {
  const SellersUpdateEvent();

  @override
  List<Object?> get props => [];
}

final class SellersUpdateRequestEvent extends SellersUpdateEvent {
  final SellersUpdateModel model;

  const SellersUpdateRequestEvent(this.model);
}
