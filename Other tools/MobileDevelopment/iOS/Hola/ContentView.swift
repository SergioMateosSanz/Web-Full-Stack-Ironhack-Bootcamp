//
//  ContentView.swift
//  Hola
//
//  Created by Miguel Castelló Sosa on 13/11/21.
//

import SwiftUI

struct ContentView: View {
    
    private var a = 8;
    
    var body: some View {
        Text("Hola iPhone \(a)!")
            .padding()
//        DatePicker(selection: /*@START_MENU_TOKEN@*/.constant(Date())/*@END_MENU_TOKEN@*/, label: { /*@START_MENU_TOKEN@*/Text("Date")/*@END_MENU_TOKEN@*/ })
//        Button(action: /*@START_MENU_TOKEN@*//*@PLACEHOLDER=Action@*/{}/*@END_MENU_TOKEN@*/) {
//            /*@START_MENU_TOKEN@*//*@PLACEHOLDER=Content@*/Text("Button")/*@END_MENU_TOKEN@*/
//        }
//        Toggle(isOn: /*@PLACEHOLDER=Is On@*/.constant(true)) {
//            Text("Toogle")
//        }
//        List {
//            /*@START_MENU_TOKEN@*//*@PLACEHOLDER=Content@*/Text("Content")/*@END_MENU_TOKEN@*/
//        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
