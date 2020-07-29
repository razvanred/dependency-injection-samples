//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation
import Cleanse

struct PrintModule : Module {
    static func configure(binder: Binder<Unscoped>) {
        binder
            .bind(Outputter.self)
            .to(factory: PrintOutputter.init)
    }
}

fileprivate struct PrintOutputter : Outputter {
    func output(_ output: String) {
        print(output)
    }
}
