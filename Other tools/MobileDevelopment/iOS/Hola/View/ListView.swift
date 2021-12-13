//
//  ListView.swift
//  Hola
//
//  Created by Miguel Castelló Sosa on 13/11/21.
//

import SwiftUI

private let programmers = [
    Programmer(id:1, name:"Alfonso",languages: "Dart", avatar: Image(systemName: "person.fill")),
    Programmer(id:2, name:"Miryam",languages: "Kotlin", avatar: Image(systemName: "person.fill")),
    Programmer(id:3, name:"Miguel",languages: "Swift", avatar: Image(systemName: "person.fill"))
]

struct ListView: View {
    var body: some View {
        NavigationView{
        List(programmers, id: \.id){
                programmer in
            NavigationLink(
                destination: ListDetailView(programmer: programmer)){
                RowView(programmer: programmer)
                }
        }
        .navigationTitle("Programadores")
        }
    }
}

struct ListView_Previews: PreviewProvider {
    static var previews: some View {
        ListView()
    }
}
