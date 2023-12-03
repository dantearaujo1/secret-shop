class ClientContact {
  final String ddd;
  final String phoneNumber;

  ClientContact(this.ddd, this.phoneNumber);

  factory ClientContact.fromJson(Map<String, dynamic> json) {
    return ClientContact(
      json['ddd'],
      json['phoneNumber'],
    );
  }
}

class ClientModel {
  final String id;
  final String name;
  final List<ClientContact> contacts;

  ClientModel(this.id, this.name, this.contacts);

  factory ClientModel.fromJson(Map<String, dynamic> json) {
    return ClientModel(
      json['id'],
      json['name'],
      (json['contacts'] as List)
          .map((contact) => ClientContact.fromJson(contact))
          .toList(),
    );
  }
}
