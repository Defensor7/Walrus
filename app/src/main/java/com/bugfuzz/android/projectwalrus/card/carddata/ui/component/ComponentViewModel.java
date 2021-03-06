/*
 * Copyright 2018 Daniel Underhay & Matthew Daley.
 *
 * This file is part of Walrus.
 *
 * Walrus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Walrus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Walrus.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.bugfuzz.android.projectwalrus.card.carddata.ui.component;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

class ComponentViewModel extends ViewModel {

    private final ComponentSourceAndSink componentSourceAndSink;

    public ComponentViewModel(ComponentSourceAndSink componentSourceAndSink) {
        this.componentSourceAndSink = componentSourceAndSink;
    }

    public ComponentSourceAndSink getComponentSourceAndSink() {
        return componentSourceAndSink;
    }

    public static class Factory implements ViewModelProvider.Factory {

        private final ComponentSourceAndSink componentSourceAndSink;

        public Factory(ComponentSourceAndSink componentSourceAndSink) {
            this.componentSourceAndSink = componentSourceAndSink;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass != ComponentViewModel.class) {
                throw new RuntimeException("Invalid view model class requested");
            }

            // noinspection unchecked
            return (T) new ComponentViewModel(componentSourceAndSink);
        }
    }
}
