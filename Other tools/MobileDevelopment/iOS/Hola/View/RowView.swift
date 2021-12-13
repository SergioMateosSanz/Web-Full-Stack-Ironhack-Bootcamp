//
//  RowView.swift
//  Hola
//
//  Created by Miguel Castelló Sosa on 13/11/21.
//

import SwiftUI

struct RowView: View {
    
    var programmer:Programmer
    
    var body: some View {
        HStack{
            programmer.avatar.resizable().frame(width: 40, height: 40, alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/)
            VStack(alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/, spacing: /*@START_MENU_TOKEN@*/nil/*@END_MENU_TOKEN@*/, content: {
                Text(programmer.name).font(.title)
                Text(programmer.languages).font(.subheadline)
            })
        }
    }
}

struct RowView_Previews: PreviewProvider {
    static var previews: some View {
        RowView(programmer: Programmer(id:1, name:"Miguel",languages: "Java", avatar: Image(systemName: "person.fill")))
    }
}
