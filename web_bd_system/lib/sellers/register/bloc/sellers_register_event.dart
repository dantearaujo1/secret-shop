import 'package:equatable/equatable.dart';
import 'package:web_bd_system/sellers/register/api/sellers_post_model.dart';

abstract class SellersRegisterEvent extends Equatable {
  const SellersRegisterEvent();

  @override
  List<Object?> get props => [];
}

final class SellersRegisterRequestEvent extends SellersRegisterEvent {
  final SellersPostModel model;

  const SellersRegisterRequestEvent(this.model);
}
