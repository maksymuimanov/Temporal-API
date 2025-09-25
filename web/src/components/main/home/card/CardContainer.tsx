import {IdeaCard} from "@/components/main/home/card/IdeaCard.tsx";
import TextType from "@/components/TextType.tsx";

export const CardContainer = () => {
    return (
        <>
            <div className="mt-50 p-25 bg-secondary border-t border-b">
                <div className="flex flex-col items-center text-4xl text-center">
                    <span className="text-4xl text-center border outline rounded-2xl p-10 bg-card">
                        <TextType
                            text={["What does the Temporal API stand for?"]}
                            typingSpeed={75}
                            pauseDuration={60}
                            showCursor={true}
                            cursorCharacter="&#9608;"
                        />
                    </span>
                </div>
                <div className="mt-20 flex gap-10 justify-center">
                    <div className="grid grid-cols-3 gap-10">
                        <IdeaCard title="Framework Flow"
                                  description="Do not reinvent the bicycle"
                                  content="Under the hood, the Temporal API ecosystem drives a several-layer pipeline to manage class injection, annotation processing, event dispatching, and data flow, so mod authors don’t write boilerplate."
                        />
                        <IdeaCard title="Registry & Annotations"
                                  description="Focus on new content and creativity"
                                  content="Temporal API provides utilities for automatic registration of items, blocks, tags, and creative tabs. With annotation support and factory helpers, you can write cleaner code and avoid repetitive registry logic."
                        />
                        <IdeaCard title="Gameplay Utilities"
                                  description="Extend Minecraft with less hassle"
                                  content="From villager trade customization to world feature utilities and FOV modifiers, Temporal API simplifies common modding tasks, giving you powerful tools to build unique gameplay mechanics 300% faster."
                        />
                        <IdeaCard title="Datagen Simplified"
                                  description="Generate assets and data automatically"
                                  content="Temporal API integrates with Minecraft’s data generation system, letting you define recipes, loot tables, and block states in code using annotations. Your mod stays clean and consistent."
                        />
                        <IdeaCard title="Object Factories"
                                  description="Build once, reuse everywhere"
                                  content="Factories in Temporal API streamline the creation of items, blocks, entities, and any other built-in registry object. This makes code declarative, and ensures consistent initialization across your mod."
                        />
                        <IdeaCard title="Extensible Structure"
                                  description="Adapt the API to your needs"
                                  content="The Temporal API is designed to be extensible: you can register your own layers, annotations, event handlers, or any other component of the framework. This flexibility enables you to tailor the framework to unique mechanics."
                        />
                    </div>
                </div>
            </div>
        </>
    );
};